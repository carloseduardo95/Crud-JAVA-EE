package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexao;
import interfaces.ProdutosCrud;
import model.Produtos;

public class ProdutosDAO implements ProdutosCrud{
	
	Conexao cnx = new Conexao();
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Produtos p1 = new Produtos();
	
	@Override
	public List list() {
		ArrayList<Produtos>list=new ArrayList<Produtos>();
		String sql="SELECT * FROM produtos";
		try {
			conn = cnx.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Produtos prod = new Produtos();
				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				prod.setPreco(rs.getFloat("preco"));
				list.add(prod);
			}
		} catch(Exception e) {
			System.out.println("Erro :"+e);
		}
		return list;
	}

	@Override
	public Produtos list(int id) {
		String sql="SELECT * FROM produtos WHERE id ="+id;
		try {
			conn = cnx.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				p1.setId(rs.getInt("id"));
				p1.setNome(rs.getString("nome"));
				p1.setPreco(rs.getFloat("preco"));
			}
		} catch(Exception e) {
			System.out.println("Erro :"+e);
		}
		return p1;
	}

	@Override
	public boolean addProduto(Produtos prod) {
		String sql = "INSERT INTO produtos (nome,preco) VALUES ('"+prod.getNome()+"','"+prod.getPreco()+"')";
		try {
			conn = cnx.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Não foi possível adicionar! "+e);
		}
		return false;
	}

	@Override
	public boolean edit(Produtos prod) {
		String sql = "UPDATE produtos SET nome='"+prod.getNome()+"', preco='"+prod.getPreco()+"' WHERE id="+prod.getId();
		try {
			conn = cnx.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Não foi possível editar! "+e);
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM produtos WHERE id="+id;
		try {
			conn = cnx.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Não foi possível excluir! "+e);
		}
		return false;
	}

}
