package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Clientes;
import modelDAO.ClientesDAO;

/**
 * Servlet implementation class ClientesController
 */
@WebServlet("/ClientesController")
public class ClientesController extends HttpServlet {
	
	String list = "view/clientes/listCliente.jsp";
	String add = "view/clientes/addCliente.jsp";
	String edit = "view/clientes/editCliente.jsp";
	
	Clientes c = new Clientes();
	ClientesDAO dao = new ClientesDAO();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acesso = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("list")) 
		{
			acesso = list;
			
			ArrayList<Clientes> clientes = (ArrayList<Clientes>) dao.list();
			
			request.getSession().setAttribute("clientes", clientes);
			
		} 
		else if(action.equalsIgnoreCase("add")) 
		{
			acesso = add;
		} 
		else if(action.equalsIgnoreCase("adicionar")) 
		{
			String nome = request.getParameter("nomeCli");
			int telefone = Integer.parseInt(request.getParameter("telefoneCli"));
			String empresa = request.getParameter("empresaCli");
			String email = request.getParameter("emailCli");
			String senha = request.getParameter("senhaCli");
			
			c.setNome(nome);
			c.setTelefone(telefone);
			c.setEmpresa(empresa);
			c.setEmail(email);
			c.setSenha(senha);
			dao.add(c);
			
			request.getSession().setAttribute("feedback", "Registro adicionado com sucesso");
			acesso = list;
		}
		else if(action.equalsIgnoreCase("edit")) 
		{
			request.setAttribute("idcli", request.getParameter("id"));
			acesso = edit;
		}
		else if(action.equalsIgnoreCase("editar")) 
		{
			int id = Integer.parseInt(request.getParameter("idCli"));
			String nome = request.getParameter("nomeCli");
			int telefone = Integer.parseInt(request.getParameter("telefoneCli"));
			String empresa = request.getParameter("empresaCli");
			String email = request.getParameter("emailCli");
			String senha = request.getParameter("senhaCli");
			
			c.setId(id);
			c.setNome(nome);
			c.setTelefone(telefone);
			c.setEmpresa(empresa);
			c.setEmail(email);
			c.setSenha(senha);
			dao.edit(c);
			
			request.getSession().setAttribute("feedback", "Registro editado com sucesso");
			acesso = list;
		}
		else if(action.equalsIgnoreCase("deletar")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			c.setId(id);
			dao.delete(id);
			
			request.getSession().setAttribute("feedback", "Registro excluído com sucesso");
			acesso = list;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(acesso);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
