/**
 * @author Daniel Espinosa
 *
 */
package modelo;


/**
 * Clase Proveedor.
 */
public class Proveedor {

	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	
	
	/**
	 * Metodo constructor de Proveedor.
	 *
	 * @param nombre -> nombre del proveedor
	 * @param telefono -> telefono del proveedor
	 */
	public Proveedor( String nombre,  String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	/**
	 * Metodo constructor de Proveedor.
	 *
	 * @param nombre -> nombre del proveedor
	 * @param telefono -> telefono del proveedor
	 * @param direccion -> dirección del proveedor
	 * @param email -> email del proveedor
	 */
	public Proveedor( String nombre, String telefono, String direccion, String email) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	public Proveedor( int id,String nombre, String telefono, String direccion, String email) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;

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
	 * @param nombre -> nombre del proveedor
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la direccion.
	 *
	 * @return direccion
	 */
	public String getdireccion() {
		return direccion;
	}

	/**
	 * Introduce la direccion.
	 *
	 * @param direccion -> direccion del proveedor
	 */
	public void setdireccion(String direccion) {
		this.direccion = direccion;
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
	 * @param telefono -> telefono del proveedor
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
	 * @param email -> email del proveedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve el id.
	 *
	 * @return  id
	 */
	public int getId() {
		return id;
	}
	
	
	
	
}
