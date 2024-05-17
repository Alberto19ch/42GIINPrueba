/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Alberto
 *
 */
public class DAOInmueble extends Dao<Inmueble>{
	DAOServicio daoServicio;
/**
 * 
 * @param db -> conexion con la base de datos
 * @param nombreTabla -> npmbre de la tabla de la base de tados
 * @param daoS -> DAO de servicio
 */
	public DAOInmueble(ConexionDB db, String nombreTabla, DAOServicio daoS) {
		super(db, nombreTabla);
		this.daoServicio = daoS;
	}
	/**
	 * Metodo que inserta un inmueble en la base de datos.
	 * 
	 * @param i -> inmueblea insertar.
	 * @return Inmueble
	 */
	@Override
	public Inmueble insertar(Inmueble i) {
		String q = "INSERT INTO "+tabla+"(planta,numero,metrosCuadrados) VALUE('"
				+ i.getPlanta() + "', '"
				+ i.getNumero() + "', '"
				+ i.getMetrosCuadrados() + "')";
		db.actualizar(q); 
		List<Map> registros = db.getUltimo(tabla);
		Inmueble inmueble= null;
		for(Map registro : registros) {
			inmueble = new Inmueble((int)registro.get("id"),
					(String)registro.get("planta"),
					(String)registro.get("numero"),
					(int)registro.get("metrosCuadrados"));
		}
		return inmueble;
	}

	/**
	 * Actualiza los campos de un inmueble de la base de datos.
	 * 
	 * @param i -> inmueble con los nuevos campos 
	 * @return int
	 */
	@Override
	public int actualizar(Inmueble i) {
		String q = "UPDATE "+tabla+" SET planta = '"
				+ i.getPlanta() + "', numero = '"
				+ i.getNumero() + "', metrosCuadrados = '"
				+ i.getMetrosCuadrados() +"' WHERE id = '"
				+ i.getId() +"'";
		return db.actualizar(q);
	}

	/**
	 * Metodo para buscar registros en la base de datos por id de inmueble.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return Inmueble
	 */
	@Override
	public Inmueble obtenerRegistro(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		Inmueble inmueble = null;
		for(Map registro : registros) {
			inmueble = new Inmueble((int)registro.get("id"),
					(String)registro.get("planta"),
					(String)registro.get("numero"),
					(int)registro.get("metrosCuadrados"));
		}
		//buscar los ids en la tabla de inmuebleServicio 		
		String q2 = "SELECT idServicio FROM inmuebleServicio WHERE idInmueble = "
				+ inmueble.getId() +";";
		List<Map> registros2 = db.ejecutar(q2);
		List<Integer> ids = new ArrayList();
		for(Map registro : registros2) {
			if(registro.get("idServicio") != null) {
				ids.add((int)registro.get("idServicio"));
			}
		}
		//Tengo una lista con los id de los Servicios de este inmueble
		//A�adir los servicios al inmueble
		for(int idServicio: ids) {
			inmueble.addServicioInmueble(daoServicio.obtenerRegistro(idServicio));		
		}
		return inmueble;
	}

	/**
	 * Metodo para obtener todos los registros de tipo inmueble de la base de datos,
	 * @return List<Inmueble>
	 */
	@Override
	public List<Inmueble> obtenerRegistros() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Inmueble> inmuebles = new ArrayList();
		for(Map registro : registros) {
			Inmueble inmueble= new Inmueble((int)registro.get("id"), 
					(String)registro.get("planta"),
					(String)registro.get("numero"),
					(int)registro.get("metrosCuadrados"));
			inmuebles.add(inmueble);
		}
		for(Inmueble inm : inmuebles) {
			//buscar los ids en la tabla de inmuebleServicio 		
			String q2 = "SELECT idServicio FROM inmuebleServicio WHERE idInmueble = "
					+ inm.getId() +";";
			List<Map> registros2 = db.ejecutar(q2);
			List<Integer> ids = new ArrayList();
			for(Map registro : registros2) {
				if(registro.get("idServicio") != null) {
					ids.add((int)registro.get("idServicio"));
				}
			}
			//Tengo una lista con los id de los Servicios de este inmueble
			//A�adir los servicios al inmueble
			for(int idServicio: ids) {
				inm.addServicioInmueble(daoServicio.obtenerRegistro(idServicio));		
			}
		}
		return inmuebles;
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
	
	/**
	 * Metodo para a�adir un servico a un inmueble.
	 * @param i -> inmueble al que a�adir el servicio
	 * @param s -> servicio a a�adir
	 * @return void
	 */
	public void anadirServicio(Inmueble i, Servicio s) {
		String q = "INSERT INTO inmuebleServicio (idInmueble,idServicio) VALUE('"
				+ i.getId() + "', '"
				+ s.getId() + "')";
		db.actualizar(q); 
		i.addServicioInmueble(s);
	}
	
	/**
	 * Metodo para eliminar un servico a un inmueble.
	 * @param i -> inmueble al que eliminar el servicio
	 * @param s -> servicio a eiminar
	 * @return void
	 */
	public void eliminarServicio(Inmueble i, Servicio s) {
		String q = "DELETE FROM inmuebleServicio WHERE idInmueble ='"
				+ i.getId() + "'AND idServicio ='"
				+ s.getId() + "';";
		db.actualizar(q); 
		i.delServicioInmueble(s);
	}
}
