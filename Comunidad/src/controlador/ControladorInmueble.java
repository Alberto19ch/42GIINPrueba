package controlador;

import java.util.List;

import modelo.DAOInmueble;
import modelo.Inmueble;
import modelo.Servicio;
/**
 * Clase encargada de gestionar las operaciones de Inmueble(crear, eliminar, actualizar,buscar, a�adir y eliminar servicios).
 */
public class ControladorInmueble {
private DAOInmueble daoI;
	
	
	public ControladorInmueble(DAOInmueble daoI) {
		this.daoI = daoI;
	}
	/**
	 * 
	 * @param i -> inmueble a insertar
	 * @return Inmueble
	 */
	public Inmueble insertar(Inmueble i) {
		return daoI.insertar(i);
	}
	/**
	 * 
	 * @param i -> inmueble a actualizar
	 * @return int
	 */
	public int actualizar(Inmueble i) {
		return daoI.actualizar(i);
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Inmueble
	 */
	public Inmueble obtenerRegistro(int id) {
		return daoI.obtenerRegistro(id);		
	}
	/**
	 * 
	 * @return List<Inmueble>
	 */
	public List<Inmueble> obtenerRegistros(){
		return daoI.obtenerRegistros();
	}
	/**
	 * 
	 * @param id -> id a eliminar
	 * @return int
	 */
	public int eliminar(int id) {
		return daoI.eliminar(id);
	}
	/**
	 * 
	 * @param i -> inmueble al que a�adir el servicio
	 * @param s -> servico a a�adir
	 */
	public void anadirServicioInmueble(Inmueble i, Servicio s) {
		daoI.anadirServicio(i, s);
	}
	/**
	 * 
	 * @param i -> inmueble al que quitar el servicio
	 * @param s -> servico a quitar
	 */
	public void eliminarServicioInmueble(Inmueble i, Servicio s) {
		daoI.eliminarServicio(i, s);
	}
}
