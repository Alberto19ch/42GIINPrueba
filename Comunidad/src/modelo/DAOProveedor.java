/**
 * @author Alberto Granado
 *
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Clase DAOProveedor
 *
 */
public class DAOProveedor extends Dao<Proveedor> {
	/**
	 * 
	 * @param db -> conexion con la bse de datos
	 * @param nombreTabla -> nombre de la tabla en la base de datos
	 */
	public DAOProveedor(ConexionDB db, String nombreTabla) {
		super(db, nombreTabla);
	}

	/**
	 * Metodo que inserta un proveedor en la base de datos.
	 * 
	 * @param p -> proveedor a insetar
	 * @return Proveedor
	 */
	public  Proveedor insertar(Proveedor p) {
		
		String q = "INSERT INTO "+tabla+"(nombre,telefono,direccion,email) VALUE('"
				+ p.getNombre() + "', '"
				+ p.getTelefono() + "', '"
				+ p.getdireccion() +  "', '"
				+ p.getEmail() + "')";
		db.actualizar(q); 
		List<Map> registros = db.getUltimo(tabla);
		Proveedor proveedor = null;
		for(Map registro : registros) {
			proveedor = new Proveedor((int)registro.get("id"),
					(String)registro.get("nombre"),
					(String)registro.get("telefono"),
					(String)registro.get("direccion"),
					(String)registro.get("email"));
		}
		return proveedor;
	}
		
	
	/**
	 * Actualiza los campos de un proveedor de la base de datos.
	 * 
	 * @param p -> proveedor con los nuevos campos 
	 * @return int
	 */
	public int actualizar(Proveedor p) {
		String q = "UPDATE "+tabla+" SET nombre = '"
				+ p.getNombre() + "', telefono = '"
				+ p.getTelefono() + "', direccion = '"
				+ p.getdireccion() +"', email = '"
				+ p.getEmail() + "' WHERE id = '"
				+ p.getId() +"'";
		return db.actualizar(q);
	}
	
	/**
	 * Metodo para buscar registros en la base de datos por id de proveedor.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return Proveedor
	 */
	public Proveedor obtenerRegistro(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		Proveedor proveedor = null;
		for(Map registro : registros) {
			proveedor = new Proveedor((int)registro.get("id"),
					(String)registro.get("nombre"),
					(String)registro.get("telefono"),
					(String)registro.get("direccion"),
					(String)registro.get("email"));
		}
		return proveedor;
	}
	
	/**
	 * Metodo para obtener todos los registros de porveedor,
	 * @return List<Proveedor>
	 */
	public List<Proveedor> obtenerRegistros() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Proveedor> proveedores = new ArrayList();
		for(Map registro : registros) {
			Proveedor proveedor = new Proveedor((int)registro.get("id"), 
					(String)registro.get("nombre"),
					(String)registro.get("telefono"),
					(String)registro.get("direccion"),
					(String)registro.get("email"));
			proveedores.add(proveedor);
		}
		return proveedores;
	}
	
	/**
	 * Metodo para eliminar un registro mediante el id.
	 * @param id
	 * @return int
	 */
	public int eliminar(int id) {
		String q = "DELETE FROM "+tabla+" WHERE id = '"
				+  id +"'";
		return db.actualizar(q);
	}
	   
}
