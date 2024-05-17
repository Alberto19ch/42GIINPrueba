package controlador;


import java.util.List;

import modelo.DAOServicio;
import modelo.Servicio;
/**
 * Clase encargada de gestionar las operaciones de Servicio(crear, eliminar, actualizar,buscar).
 */
public class ControladorServicio {
	private DAOServicio daoS;
	
	public ControladorServicio(DAOServicio daoS) {
		this.daoS = daoS;
	}
	/**
	 * 
	 * @param s -> servicio a insertar
	 * @return
	 */
	public Servicio insertar(Servicio s) {
		return daoS.insertar(s);
	}
	/**
	 * 
	 * @param s -> servivio a actualizar
	 * @return int
	 */
	public int actualizar(Servicio s) {
		return daoS.actualizar(s);
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Servicio
	 */
	public Servicio obtenerRegistro(int id) {
		return daoS.obtenerRegistro(id);
	}
	/**
	 * 
	 * @return List<Servicio>
	 */
	public List<Servicio> obtenerRegistros(){
		return daoS.obtenerRegistros();
	}
	/**
	 * 
	 * @param id -> id a eliminar
	 * @return int
	 */
	public int eliminar(int id) {
		return daoS.eliminar(id);
	}
}
