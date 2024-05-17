package controlador;

import java.util.List;

import modelo.DAOGastos;
import modelo.Gastos;
/**
 * Clase encargada de gestionar las operaciones de Gastos(crear, eliminar, actualizar,buscar).
 */
public class ControladorGastos {
	private DAOGastos daoG;
	
	public ControladorGastos(DAOGastos daoG) {
		this.daoG= daoG;
	}
	/**
	 * 
	 * @param g -> gasto a insertar
	 * @return Gastos
	 */
	public Gastos insertar(Gastos g) {
		return daoG.insertar(g);
	}
	/**
	 * 
	 * @param g -> gasto a actualizar
	 * @return int
	 */
	public int actualizar(Gastos g) {
		return daoG.actualizar(g);
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Gasto
	 */
	public Gastos obtnerRegistro(int id) {
		return daoG.obtenerRegistro(id);
	}
	/**
	 * 
	 * @return List<Gastos>
	 */
	public List<Gastos> obtnerRegistros(){
		return daoG.obtenerRegistros();
	}
	/**
	 * 
	 * @param id -> id a eliminar
	 * @return
	 */
	public int eliminar (int id) {
		return daoG.eliminar(id);
	}
}
