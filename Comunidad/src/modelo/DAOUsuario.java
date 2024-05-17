/**
 * 
 */
package modelo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Alberto
 *
 */
public class DAOUsuario extends Dao<Vecino> {
	DAOInmueble daoInmueble;

	public DAOUsuario(ConexionDB db, String nombreTabla, DAOInmueble daoI) {
		super(db, nombreTabla);
		this.daoInmueble = daoI;
	}

	/**
	 * Metodo que inserta un vecinio en la base de datos.
	 * 
	 * @param v -> vecino con los campos
	 * @return Vecino
	 */
	public Vecino insertar(Vecino v) {
		String q = "INSERT INTO "+tabla+"(tipo,nombre,clave,telefono,email) VALUE('"
				+ 0 + "', '"
				+ v.getNombre() + "', '"
				+ v.getClave() +  "', '"
				+ v.getTelefono() +  "', '"
				+ v.getEmail() + "')";
		db.actualizar(q); 
		List<Map> registros = db.getUltimo(tabla);
		Vecino vecino= null;
		for(Map registro : registros) {
			vecino = new Vecino((int)registro.get("id"),
					(String)registro.get("nombre"),
					(String)registro.get("clave"),
					(String)registro.get("telefono"),
					(String)registro.get("email"));
		}
		return vecino;
	}
	/**
	 * Metodo que inserta un administrador en la base de datos.
	 * 
	 * @param a -> administrador con los campos 
	 * @return Vecino
	 */
	public Administrador insertar(Administrador a) {
		String q = "INSERT INTO "+tabla+"(tipo,nombre,clave,telefono,email) VALUE('"
				+ 1 + "', '"
				+ a.getNombre() + "', '"
				+ a.getClave() +  "', '"
				+ a.getTelefono() +  "', '"
				+ a.getEmail() + "')";
		db.actualizar(q); 
		List<Map> registros = db.getUltimo(tabla);
		Administrador admin= null;
		for(Map registro : registros) {
			admin = new Administrador((int)registro.get("id"),
					(String)registro.get("nombre"),
					(String)registro.get("clave"),
					(String)registro.get("telefono"),
					(String)registro.get("email"));
		}
		return admin;
	}
	/**
	 * Actualiza los campos de un vecino de la base de datos.
	 * 
	 * @param v -> vecino con los nuevos campos
	 * @return int
	 */
	public int actualizar(Vecino v) {		
		String q = "UPDATE "+tabla+" SET nombre = '"
			+ v.getNombre() + "', clave = '"
			+ v.getClave() + "', telefono = '"
			+ v.getTelefono() +"', email = '"
			+ v.getEmail() + "' WHERE id = '"
			+ v.getId() +"'";
	return db.actualizar(q);
	}
	/**
	 * Actualiza los campos de un administrador de la base de datos.
	 * 
	 * @param a -> adiminstrador con los nuevos campos
	 * @return int
	 */
	public int actualizar(Administrador a) {		
		String q = "UPDATE "+tabla+" SET nombre = '"				
				+ a.getNombre() + "', clave = '"
				+ a.getClave() + "', telefono = '"
				+ a.getTelefono() +"', email = '"
				+ a.getEmail() + "' WHERE id = '"
				+ a.getId() +"'";
		return db.actualizar(q);
	}

	/**
	 * Metodo para buscar registros en la base de datos por el id de usuario.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return Vecino
	 */
	public Vecino obtenerRegistroV(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		Vecino v= null;
		for(Map registro : registros) {
			v = new Vecino((int)registro.get("id"),
					(String)registro.get("nombre"),
					(String)registro.get("clave"),
					(String)registro.get("telefono"),
					(String)registro.get("email"));
		}
		//buscar los ids en la tabla de usuarioInmueble 		
		String q2 = "SELECT idInmueble FROM usuarioInmueble WHERE idUsuario = "
				+ v.getId() +";";
		List<Map> registros2 = db.ejecutar(q2);
		List<Integer> ids = new ArrayList();
		for(Map registro : registros2) {
			if(registro.get("idInmueble") != null) {
				ids.add((int)registro.get("idInmueble"));
			}
		}
		//Tengo una lista con los id de los inmuebles de este vecino
		//A�adir los inmuebles al vecino
		for(int idInmueble: ids) {
			v.addInmueble(daoInmueble.obtenerRegistro(idInmueble));		
		}
		return v;
	}
	/**
	 * Metodo para buscar registros en la base de datos por el id de usuario.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return Administrador
	 */
	public Administrador obtenerRegistroA(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		Administrador a= null;
		for(Map registro : registros) {
			a = new Administrador((int)registro.get("id"),
					(String)registro.get("nombre"),
					(String)registro.get("clave"),
					(String)registro.get("telefono"),
					(String)registro.get("email"));
		}
		return a;
	}

	/**
	 * Metodo para obtener todos los registros de usuario de tipo vecino,
	 * @return List
	 */
	public List<Vecino> obtenerRegistrosV() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Vecino> vecinos = new ArrayList();
		for(Map registro : registros) {
			Vecino vecino= new Vecino((int)registro.get("id"), 
					(String)registro.get("nombre"),
					(String)registro.get("clave"),
					(String)registro.get("telefono"),
					(String)registro.get("email"));
						
			vecinos.add(vecino);
		}
		for(Vecino v: vecinos) {
			//buscar los ids en la tabla de usuarioInmueble 		
			String q2 = "SELECT idInmueble FROM usuarioInmueble WHERE idUsuario = "
					+ v.getId() +";";
			List<Map> registros2 = db.ejecutar(q2);
			List<Integer> ids = new ArrayList();
			for(Map registro : registros2) {
				if(registro.get("idInmueble") != null) {
					ids.add((int)registro.get("idInmueble"));
				}
			}
			//Tengo una lista con los id de los inmuebles de este vecino
			//A�adir los inmuebles al vecino
			for(int idInmueble: ids) {
				v.addInmueble(daoInmueble.obtenerRegistro(idInmueble));		
			}
		}
		return vecinos;
	}
	/**
	 * Metodo para obtener todos los registros de usuario de tipo Administrador,
	 * @return List
	 */
	public List<Administrador> obtenerRegistrosA() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Administrador> admins = new ArrayList();
		for(Map registro : registros) {
			Administrador admin= new Administrador((int)registro.get("id"), 
					(String)registro.get("nombre"),
					(String)registro.get("clave"),
					(String)registro.get("telefono"),
					(String)registro.get("email"));
			admins.add(admin);
		}
		return admins;
	}

	@Override
	public int eliminar(int id) {
		String q = "DELETE FROM "+tabla+" WHERE id = '"
				+  id +"'";
		return db.actualizar(q);
	}
	/**
	 * Metodo para a�adir un inmueble como propiedad de un vecino.
	 * @param v -> vecino due�o del inmueble
	 * @param i -> inmueble a a�adir
	 * @return void
	 */
	public void anadirInmueble(Vecino v, Inmueble i) {
		String q = "INSERT INTO usuarioInmueble (idUsuario,idInmueble) VALUE('"
				+ v.getId() + "', '"
				+ i.getId() + "')";
		db.actualizar(q); 
		v.addInmueble(i);
	}
	/**
	 * Metodo para eliminar un inmueble como propiedad de un vecino.
	 * @param v -> vecino exdue�o del inmueble
	 * @param i -> inmueble a eliminar
	 * @return void
	 */
	public void eliminarInmueble(Vecino v, Inmueble i) {
		String q = "DELETE FROM usuarioInmueble WHERE idUsuario ='"
				+ v.getId() + "'AND idInmueble ='"
				+ i.getId() + "';";
		db.actualizar(q); 
		v.deleteInmueble(i);
	}
	@Override
	public Vecino obtenerRegistro(int id) {
		return null;
	}
	@Override
	public List<Vecino> obtenerRegistros() {
		return null;
	}


}
