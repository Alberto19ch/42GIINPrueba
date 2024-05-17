/**
 * 
 */
package modelo;

/**
 * @author Alberto Granado
 *
 */
public class Administrador extends Usuario {
	/**
	 * Metodo constructor de Administrador.
	 *
	 *@param id -> id del usuario
	 * @param nombre -> nombre del usuario
	 * @param clave -> calve del usuario
	 * @param telefono -> numero de telefono del usuario
	 * @param email -> email del usuario
	 */
	public Administrador(int id, String nombre, String clave, String telefono, String email) {
		super(id, nombre, clave, telefono, email);
	}
	public Administrador(String nombre, String clave, String telefono, String email) {
		super(nombre, clave, telefono, email);
	}
	/**
	 * Crea un nuevo usuario de tipo vecino
	 * @param id -> id del usuario nuevo
	 * @param nombre -> nombre del usuario nuevo
	 * @param clave -> clave del usuario nuevo
	 * @param telefono -> numero de telefono del usuario nuevo
	 * @param email -> email del usuario nuevo
	 * @param inmueble -> inmuebles del usuario nuevo
	 * @return vecino
	 */
	public Vecino altaUsuario(int id, String nombre, String clave, String telefono, String email, Inmueble inmueble) {
		//METER CONTROL DE ERRORES
		Vecino vecino = new Vecino(id, nombre, clave, telefono, email, inmueble);
		return vecino;
	}
	/****************************REVISAR***************************************/
	/**
	 * Da de baja un usuario
	 *
	 * @param usuario -> instancia del usuario
	 * @return True si se podroduce la baja correctamente
	 */
	public boolean bajaUsuario(Usuario usuario) {
		// pendiente de logica
		return true;
	}
	/*
	 * Modificacion de los campos de Usuario
	 */
	
	/**
	 * Modifica el nombre del vecino.
	 *
	 * @param vecino -> vecino al que cambiar el nombre
	 * @param nombre -> nombre nuevo para el vecino
	 */
	public void setNombreUsuario(Vecino vecino, String nombre) {
		vecino.setNombre(nombre);
	}
	/**
	 * Modifica la clave del vecino.
	 *
	 * @param vecino -> vecino al que cambiar la clave
	 * @param clave -> clave nueva para el vecino
	 */
	public void setClaveUsuario(Vecino vecino, String clave) {
		vecino.setClave(clave);
	}
	/**
	 * Modifica el telefono del usuario.
	 *
	 * @param vecino -> vecino al que cambiar el telefono
	 * @param telefono -> telefono nuevo para el vecino
	 */
	public void setTelefonoUsuario(Vecino vecino, String telefono) {
		vecino.setTelefono(telefono);
	}
	/**
	 * Modifica el email del usuario.
	 *
	 * @param vecino -> vecino al que cambiar el email
	 * @param email -> email nuevo para el vecino
	 */
	public void setEmailUsuario(Vecino vecino, String email) {
		vecino.setEmail(email);
	}
	
	
}
