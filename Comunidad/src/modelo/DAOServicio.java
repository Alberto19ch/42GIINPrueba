/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Clase DAOServicio
 *
 */
public class DAOServicio extends Dao<Servicio> {
	DAOGastos daoGastos;
	/**
	 * 
	 * @param db -> conexoin con la base de datos
	 * @param nombreTabla -> nombre de la tabla en la base de datos
	 * @param daoG -> DAO de gastos
	 */
	public DAOServicio(ConexionDB db, String nombreTabla, DAOGastos daoG) {
		super(db, nombreTabla);
		this.daoGastos = daoG;
	}

	/**
	 * Metodo que inserta un servicio en la base de datos segun sea obligatorio o no.
	 * 
	 * @param s -> servicio a insertar.
	 * @return Servicio
	 */
	@Override
	public Servicio insertar(Servicio s) {
		
		if(s.getEsObligatorio()) { /* Si es obligatorio se inserta 1*/
			String q = "INSERT INTO "+tabla+"(nombre,esObligatorio,coste,gasto) VALUE('"
					+ s.getNombre() + "', '"
					+ 1 + "', '"
					+ s.getCoste() + "', '"
					+ s.getGasto().getId() + "')";
			db.actualizar(q); 
		}else { /* Si no es obligatorio se inserta 0*/
			String q = "INSERT INTO "+tabla+"(nombre,esObligatorio,coste,gasto) VALUE('"
					+ s.getNombre() + "', '"
					+ 0 + "', '"
					+ s.getCoste() + "', '"
					+ s.getGasto().getId() + "')";
			db.actualizar(q); 
		}

		List<Map> registros = db.getUltimo(tabla);
		Servicio servicio = null;
		
		for(Map registro : registros) {
			Gastos g = daoGastos.obtenerRegistro((int)registro.get("gasto")); 
			if((int)registro.get("esObligatorio") == 1) {
				servicio = new Servicio((int)registro.get("id"),
						(String)registro.get("nombre"),
						true,
						(int)registro.get("coste"),
						g);
			}else {
				servicio = new Servicio((int)registro.get("id"),
						(String)registro.get("nombre"),
						false,
						(int)registro.get("coste"),
						g);
			}
		}
		return servicio;
	}

	/**
	 * Actualiza los campos de un servicio de la base de datos.
	 * 
	 * @param s -> serrvicio con los nuevos campos 
	 * @return int
	 */
	@Override
	public int actualizar(Servicio s) {
		if(s.getEsObligatorio()) {
			String q = "UPDATE "+tabla+" SET nombre = '"
					+ s.getNombre() + "', esObligatorio = '"
					+ 1 + "', coste = '"
					+ s.getCoste() + "', gasto = '"
					+ s.getGasto().getId() + "' WHERE id = '"
					+ s.getId() +"'";
			return db.actualizar(q);
		}
		
		String q = "UPDATE "+tabla+" SET nombre = '"
				+ s.getNombre() + "', esObligatorio = '"
				+ 0 + "', coste = '"
				+ s.getCoste() + "', gasto = '"
				+ s.getGasto().getId() + "' WHERE id = '"
				+ s.getId() +"'";
		return db.actualizar(q);
	}

	/**
	 * Metodo para buscar registros en la base de datos por id de servicio.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return Servicio
	 */
	@Override
	public Servicio obtenerRegistro(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		Servicio servicio = null;
		for(Map registro : registros) {
			Gastos g = daoGastos.obtenerRegistro((int)registro.get("gasto")); 
			if((int)registro.get("esObligatorio") == 1) {
				servicio = new Servicio((int)registro.get("id"),
						(String)registro.get("nombre"),
						true,
						(int)registro.get("coste"),
						g);
			}else {
				servicio = new Servicio((int)registro.get("id"),
						(String)registro.get("nombre"),
						false,
						(int)registro.get("coste"),
						g);
			}
		}
		return servicio;
	}

	/**
	 * Metodo para obtener todos los registros de tipo servicio de la base de datos,
	 * @return List<Servicio>
	 */
	@Override
	public List<Servicio> obtenerRegistros() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Servicio> servicios = new ArrayList();
		for(Map registro : registros) {
			Gastos g = daoGastos.obtenerRegistro((int)registro.get("gasto")); 
			if((int)registro.get("esObligatorio") == 1) {
				Servicio servicio = new Servicio((int)registro.get("id"),
						(String)registro.get("nombre"),
						true,
						(int)registro.get("coste"),
						g);
				servicios.add(servicio);
			}else {
				Servicio servicio = new Servicio((int)registro.get("id"),
						(String)registro.get("nombre"),
						false,
						(int)registro.get("coste"),
						g);
				servicios.add(servicio);
			}
		}
		return servicios;
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
