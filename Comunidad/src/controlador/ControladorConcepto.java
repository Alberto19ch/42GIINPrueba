package controlador;

import java.util.List;

import modelo.Concepto;
import modelo.DAOConcepto;
/**
 * Clase encargada de gestionar las operaciones de Concepto(crear, eliminar, actualizar,buscar).
 */
public class ControladorConcepto {
	private DAOConcepto daoC;
	
	public ControladorConcepto(DAOConcepto daoC) {
		this.daoC= daoC;
	}
	/**
	 * 
	 * @param c -> concepto a insetar
	 * @return
	 */
	public Concepto insertar(Concepto c) {
		return daoC.insertar(c);
	}
	/**
	 * 
	 * @param c -> concepto a actualizar
	 * @return
	 */
	public int actualizar(Concepto c) {
		return daoC.actualizar(c);
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Proveedor
	 */
	public Concepto obtonerRegistro(int id) {
		return daoC.obtenerRegistro(id);
	}
	/**
	 * 
	 * @return List<Concepto>
	 */
	public List<Concepto> obtenerRegistos(){
		return daoC.obtenerRegistros();
	}
	/**
	 * 
	 * @param id -> id a eliminar
	 * @return int 
	 */
	public int eliminar(int id) {
		return daoC.eliminar(id);
	}
}
