package controlador;


import java.util.List;

import modelo.Administrador;
import modelo.DAOUsuario;
import modelo.Inmueble;
import modelo.Vecino;
/**
 * Clase encargada de gestionar las operaciones de Usuarios(crear, eliminar, actualizar,buscar).
 */
public class ControladorUsuario {
	private DAOUsuario daoUsuario;
	
	public ControladorUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	/**
	 * 
	 * @param v -> vecino a insetar
	 * @return Vecino
	 */
	public Vecino insertarVecino(Vecino v) {
		return daoUsuario.insertar(v); 
	}
	/**
	 * 
	 * @param a -> admin a insetar
	 * @return Administrador
	 */
	public Administrador insertarAdministrador(Administrador a) {
		return daoUsuario.insertar(a);
	}
	/**
	 * 
	 * @param v -> vecino a actualizar
	 * @return int
	 */
	public int actualizarVecino(Vecino v) {
		return daoUsuario.actualizar(v);
	}
	/**
	 * 
	 * @param a -> admin a actualizar
	 * @return int
	 */
	public int actualizarAdministrador(Administrador a) {
		return daoUsuario.actualizar(a);
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Vecino
	 */
	public Vecino obtenerRegistroVecino(int id) {
		return daoUsuario.obtenerRegistroV(id);
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Administrador
	 */
	public Administrador obtenerRegistroAdministrador(int id) {
		return daoUsuario.obtenerRegistroA(id);
	}
	/**
	 * 
	 * @return List<Vecino>
	 */
	public List<Vecino> obtenerRegsitrosVecino(){
		return daoUsuario.obtenerRegistrosV();
	}
	/**
	 * 
	 * @return List<Administrador>
	 */
	public List<Administrador> obtenerRegsitrosAdministrador(){
		return daoUsuario.obtenerRegistrosA();
	}
	/**
	 * 
	 * @param id -> id a eliminar
	 * @return int 
	 */
	public int eliminar(int id) {
		return daoUsuario.eliminar(id);
	}
	/**
	 * 
	 * @param v -> vecino al que se le a�ede el inmueble
	 * @param i -> inmueble del vecinio
	 */
	public void anadirInmuebleVecino(Vecino v, Inmueble i) {
		daoUsuario.anadirInmueble(v, i);
	}
	/**
	 * 
	 * @param v -> vecinio al que se le va a quitar el inmueble
	 * @param i -> inmueble a quitar
	 */
	public void eliminarInmuebleVecino(Vecino v, Inmueble i) {
		daoUsuario.eliminarInmueble(v, i);
	}
}
