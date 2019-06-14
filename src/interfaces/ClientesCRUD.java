package interfaces;

import java.util.List;

import model.Clientes;

public interface ClientesCRUD {
	public List list();
	public Clientes list(int id);
	public boolean add(Clientes cli);
	public boolean edit(Clientes cli);
	public boolean delete(int id);
}
