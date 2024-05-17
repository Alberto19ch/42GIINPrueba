package controlador;

import java.util.List;

import modelo.DAOLiquidacion;
import modelo.Liquidacion;
/**
 * Clase encargada de gestionar las operaciones de Liquidacion(crear, eliminar, actualizar,buscar).
 */
public class ControladorLiquidacion {
	private DAOLiquidacion daoL;

	public ControladorLiquidacion(DAOLiquidacion daoL) {
		this.daoL = daoL;
	}
	/**
	 * 
	 * @param l -> liquidacion a insertar
	 * @return Liquidacion
	 */
	public Liquidacion insertar(Liquidacion l) {
		return daoL.insertar(l);
	}
	/**
	 * 
	 * @param l -> liquidacion a actualizar
	 * @return int
	 */
	public int actualizar(Liquidacion l) {
		return daoL.actualizar(l);
	}
	/**
	 * 
	 * @param id -> id a buscar
	 * @return Proveedor
	 */	
	public Liquidacion obtenerRegistro(int id) {
		return daoL.obtenerRegistro(id);
	}
	/**
	 * 
	 * @return List<Liquidacion>
	 */
	public List<Liquidacion> obtenerRegistros(){
		return daoL.obtenerRegistros();
	}
	/**
	 * 
	 * @param id -> id a eliminar
	 * @return int 
	 */
	public int eliminar(int id) {
		return daoL.eliminar(id);
	}
}
