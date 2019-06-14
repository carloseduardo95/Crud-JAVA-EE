package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produtos;
import modelDAO.ProdutosDAO;

/**
 * Servlet implementation class ProdutosController
 */
@WebServlet("/ProdutosController")
public class ProdutosController extends HttpServlet {
	
	String list = "/view/produtos/listProduto.jsp";
	String add = "/view/produtos/addProduto.jsp";
	String edit = "/view/produtos/editProduto.jsp";
	
	Produtos prod = new Produtos();
	ProdutosDAO prodao = new ProdutosDAO();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutosController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("list")) 
		{
			pagina = list;
		} 
		else if(action.equalsIgnoreCase("add")) 
		{
			pagina = add;
		} 
		else if(action.equalsIgnoreCase("adicionar")) 
		{
			String nome = request.getParameter("txtNome");
			float preco = Float.parseFloat(request.getParameter("txtPreco"));
			prod.setNome(nome);
			prod.setPreco(preco);
			prodao.addProduto(prod);
			
			request.getSession().setAttribute("feedback", "Registro adicionado com sucesso");
			pagina = list;
		}
		else if(action.equalsIgnoreCase("edit")) 
		{
			request.setAttribute("idprod", request.getParameter("id"));
			pagina = edit;
		}
		else if(action.equalsIgnoreCase("editar")) 
		{
			int id = Integer.parseInt(request.getParameter("txtId"));
			String nome = request.getParameter("txtNome");
			float preco = Float.parseFloat(request.getParameter("txtPreco"));
			
			prod.setId(id);
			prod.setNome(nome);
			prod.setPreco(preco);
			prodao.edit(prod);
			
			request.getSession().setAttribute("feedback", "Registro editado com sucesso");
			pagina = list;
		}
		else if(action.equalsIgnoreCase("deletar")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			prod.setId(id);
			prodao.delete(id);
			
			request.getSession().setAttribute("feedback", "Registro excluído com sucesso");
			pagina = list;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(pagina);
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
