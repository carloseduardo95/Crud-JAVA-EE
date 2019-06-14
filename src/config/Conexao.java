package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	Connection con;
	
	public Conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registro?useSSL=false","carlos","1234");
		} catch (Exception e) {
			System.err.println("Error"+e);
		}
	}
	public Connection getConnection() {
		return con;
	}
}
