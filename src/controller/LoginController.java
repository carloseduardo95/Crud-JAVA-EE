package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Conexao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	Conexao cn = new Conexao();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		String sql = "SELECT email, senha FROM usuarios WHERE email= ?";
		
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				String login = rs.getString("email");
				String password = rs.getString("senha");
				
				//Realiza login
				if (email.equals(login) && senha.equals(password)) {
					
					request.getSession().setAttribute("feedback", "Login efetuado com sucesso!");
					response.sendRedirect("dashboard.jsp");
				} else {
					//request.setAttribute("message", "Login e/ou senha inválidos.");
					request.getSession().setAttribute("feedback_erro", "Login e/ou senha inválidos!");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);			
				}
			}
		} catch(Exception e) {
			System.out.println("Erro :"+e);
		}
		
		/*Simulando um banco de dados
		if (email.equals("teste@teste.com.br") && senha.equals("123")) {
			
			request.getSession().setAttribute("feedback", "Login efetuado com sucesso!");
			response.sendRedirect("dashboard.jsp");
		} else {
			//request.setAttribute("message", "Login e/ou senha inválidos.");
			request.getSession().setAttribute("feedback_erro", "Login e/ou senha inválidos!");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);			
		}*/
	}

}
