package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexao;
import interfaces.ClientesCRUD;
import model.Clientes;

public class ClientesDAO implements ClientesCRUD {
	
	public ClientesDAO() {
		super();
	}
	
	Conexao cn = new Conexao();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Clientes c = new Clientes();
	
	@Override
	public List list() {
		ArrayList<Clientes>list=new ArrayList<Clientes>();
		String sql="SELECT * FROM clientes";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Clientes cli = new Clientes();
				cli.setId(rs.getInt("id"));
				cli.setNome(rs.getString("nome"));
				cli.setTelefone(rs.getInt("telefone"));
				cli.setEmpresa(rs.getString("empresa"));
				cli.setEmail(rs.getString("email"));
				cli.setSenha(rs.getString("senha"));
				list.add(cli);
			}
		} catch(Exception e) {
			System.out.println("Erro :"+e);
		}
		return list;
	}

	@Override
	public Clientes list(int id) {
		String sql="SELECT * FROM clientes WHERE id ="+id;
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getInt("telefone"));
				c.setEmpresa(rs.getString("empresa"));
				c.setEmail(rs.getString("email"));
				c.setSenha(rs.getString("senha"));
			}
		} catch(Exception e) {
			System.out.println("Erro :"+e);
		}
		return c;
	}

	@Override
	public boolean add(Clientes cli) {
		String sql = "INSERT INTO clientes (nome, telefone, empresa, email, senha) VALUES ('"+cli.getNome()+"','"+cli.getTelefone()+"','"+cli.getEmpresa()+"','"+cli.getEmail()+"','"+cli.getSenha()+"')";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Não foi possível adicionar! "+e);
		}
		return false;
	}

	@Override
	public boolean edit(Clientes cli) {
		String sql = "UPDATE clientes SET nome='"+cli.getNome()+"', telefone='"+cli.getTelefone()+"', empresa='"+cli.getEmpresa()+"', email='"+cli.getEmail()+"', senha='"+cli.getSenha()+"' WHERE id="+cli.getId();
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Não foi possível editar! "+e);
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM clientes WHERE id="+id;
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Não foi possível excluir! "+e);
		}
		return false;
	}
	
}
