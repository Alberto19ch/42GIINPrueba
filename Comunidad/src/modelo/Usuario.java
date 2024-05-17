package modelo;

/**
 * Clase Usuario.
 */
public abstract class Usuario {
	
	protected int id;
	protected String nombre;
	protected String clave;
	protected String telefono;
	protected String email;
	
	
	/**
	 * Metodo constructor de Usuario.
	 *
	 *@param id -> id del usuario
	 * @param nombre -> nombre del usuario
	 * @param clave -> calve del usuario
	 * @param telefono -> numero de telefono del usuario
	 * @param email -> email del usuario
	 */
	public Usuario(int id, String nombre, String clave, String telefono, String email) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.telefono = telefono;
		this.email = email;
	}
	public Usuario(String nombre, String clave, String telefono, String email) {
		this.nombre = nombre;
		this.clave = clave;
		this.telefono = telefono;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return nombre;		
	}
	/**
	 * Devuelve el nombre.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Introduce el nombre.
	 *
	 * @param nombre -> nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve la clave.
	 *
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * Introduce la clave.
	 *
	 * @param clave -> clave del usuario
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * Devuelve el telefono.
	 *
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Introduce el telefono.
	 *
	 * @param telefono -> telefono del usuario
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Devuelve el email.
	 *
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Introduce el email.
	 *
	 * @param email -> email del usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Devuelve el id.
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}
}
