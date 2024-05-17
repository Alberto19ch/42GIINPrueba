/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Date;

/**
 * @author Alberto
 *
 */
public class DAOLiquidacion extends Dao<Liquidacion> {
	/**
	 * 
	 * @param db -> conexion con la base de datos.
	 * @param nombreTabla -> nombre de la tabla en la base de datos.
	 */
	public DAOLiquidacion(ConexionDB db, String nombreTabla) {
		super(db, nombreTabla);
	}
	/**
	 * Metodo que inserta una liquidacion en la base de datos.
	 * 
	 * @param l -> liquidacion a insetar
	 * @return Liquidacion
	 */
	@Override
	public Liquidacion insertar(Liquidacion l) {
		String q = "INSERT INTO "+tabla+"(fechaInicio,fechaFin) VALUE('"
				+ l.getFechaInicio() + "', '"
				+ l.getFechaFin() + "')";
		db.actualizar(q); 
		List<Map> registros = db.getUltimo(tabla);
		Liquidacion liquidacion= null;
		for(Map registro : registros) {
			liquidacion = new Liquidacion((int)registro.get("id"),
					(Date)registro.get("fechaInicio"),
					(Date)registro.get("fechaFin"));
		}
		return liquidacion;
	}
	/**
	 * Actualiza los campos de una liquidacion de la base de datos.
	 * 
	 * @param l -> liquidacion con los nuevos campos 
	 * @return int
	 */
	@Override
	public int actualizar(Liquidacion l) {
		String q = "UPDATE "+tabla+" SET fechaInicio = '"
				+ l.getFechaInicio() + "', fechaFin = '"
				+ l.getFechaFin() +"'";
		return db.actualizar(q);
	}
	/**
	 * Metodo para buscar registros en la base de datos por id de liquidacion.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return Liquidacion
	 */
	@Override
	public Liquidacion obtenerRegistro(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		Liquidacion liquidacion= null;
		for(Map registro : registros) {
			liquidacion = new Liquidacion((int)registro.get("id"),
					(Date)registro.get("fechaInicio"),
					(Date)registro.get("fechaFin"));
		}
		return liquidacion;
	}
	/**
	 * Metodo para obtener todos los registros de liquidacion,
	 * @return List<Liquidacion>
	 */
	@Override
	public List<Liquidacion> obtenerRegistros() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Liquidacion> liquidaciones = new ArrayList();
		for(Map registro : registros) {
			Liquidacion liquidacion= new Liquidacion((int)registro.get("id"), 
					(Date)registro.get("fechaInicio"),
					(Date)registro.get("fechaFin"));
			liquidaciones.add(liquidacion);
		}
		return liquidaciones;
	}
	/**
	 * Metodo para eliminar un registro mediante el id.
	 * @param id
	 * @return int
	 */
	@Override
	public int eliminar(int id) {
		String q = "DELETE FROM "+tabla+" WHERE id = '"
				+  id +"'";
		return db.actualizar(q);
	}

}
