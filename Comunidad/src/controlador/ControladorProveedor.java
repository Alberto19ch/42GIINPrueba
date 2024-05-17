package controlador;

import java.util.List;

import modelo.DAOProveedor;
import modelo.Proveedor;

/**
 * Clase encargada de gestionar las operaciones de Proveedor(crear, eliminar, actualizar,buscar).
 */
public class ControladorProveedor {
	private DAOProveedor daoProveedor;
	
	public ControladorProveedor(DAOProveedor daoProveedor) {
		this.daoProveedor = daoProveedor;
	}
	/**
	 * 
	 * @param p -> proveedor a insetar 
	 * @return Proveedor
	 */
	public Proveedor insertarProveedor(Proveedor p) {
		return daoProveedor.insertar(p);
	}
	/**
	 * 
	 * @param p -> proveedor a actualizar
	 * @return int
	 */
	public int actualizar(Proveedor p) {
		int i = daoProveedor.actualizar(p);
		return i;
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Proveedor
	 */
	public Proveedor obtnenerRegistro(int id) {
		return daoProveedor.obtenerRegistro(id);
	}
	/**
	 * 
	 * @return List<Proveedor>
	 */
	public List<Proveedor> obtenerRegistros(){
		return daoProveedor.obtenerRegistros();
	}
	/**
	 * 
	 * @param id -> id a eliminar
	 * @return int 
	 */
	public int eliminar(int id) {
		return daoProveedor.eliminar(id);
	}
}
