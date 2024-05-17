/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Clase DAOConcepto
 *
 */
public class DAOConcepto extends Dao<Concepto> {
	DAOServicio daoServicio;
	/**
	 * 
	 * @param db -> conexion a la base de datos
	 * @param nombreTabla -> nombre de la tabla
	 * @param daoS -> DAO de servicio
	 */
	public DAOConcepto(ConexionDB db, String nombreTabla, DAOServicio daoS) {
		super(db, nombreTabla);
		this.daoServicio = daoS;
	}
	/**
	 * Metodo que inserta un concepto en la base de datos.
	 * 
	 * @param c -> concepto a insertar.
	 * @return Concepto
	 */
	@Override
	public Concepto insertar(Concepto c) {
		String q = "INSERT INTO "+tabla+"(descripcion, servicio) VALUE('"
				+ c.getDescripcion() + "', '"
				+ c.getServicio().getId() + "')";
		db.actualizar(q); 
		List<Map> registros = db.getUltimo(tabla);
		Concepto concepto = null;
		for(Map registro : registros) {
			
		}
		return c;
	}
	/**
	 * Actualiza los campos de un concepto de la base de datos.
	 * 
	 * @param c -> concepto con los nuevos campos 
	 * @return int
	 */
	@Override
	public int actualizar(Concepto c) {
		String q = "INSERT INTO "+tabla+"(descripcion, servicio) VALUE('"
				+ c.getDescripcion() + "', '"
				+ c.getServicio().getId() + "')";
		return db.actualizar(q);
	}
	
	/**
	 * Metodo para buscar registros en la base de datos por id de concepto.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return Concepto
	 */
	@Override
	public Concepto obtenerRegistro(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		ConceptoSimple c = null;
		for(Map registro : registros) {
			c = new ConceptoSimple((int)registro.get("id"),
					(String)registro.get("descripcion"),
					daoServicio.obtenerRegistro((int)registro.get("servicio")));
		}
		return c;
	}
	
	/**
	 * Metodo para obtener todos los registros de tipo concepto de la base de datos,
	 * @return List<Proveedor>
	 */
	@Override
	public List<Concepto> obtenerRegistros() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Concepto> conceptos = new ArrayList();
		for(Map registro : registros) {
			Servicio s = daoServicio.obtenerRegistro((int)registro.get("servicio"));
			ConceptoSimple concepto= new ConceptoSimple((int)registro.get("id"), 
					(String)registro.get("descripcion"),
					s);
			conceptos.add(concepto);
		}
		return conceptos;
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
