package interfaces;

import java.util.List;

import model.Produtos;

public interface ProdutosCrud {
	public List list();
	public Produtos list(int id);
	public boolean addProduto(Produtos prod);
	public boolean edit(Produtos prod);
	public boolean delete(int id);
}
