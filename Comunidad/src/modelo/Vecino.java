/**
 * 
 */
package modelo;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Alberto Granado
 *
 */
public class Vecino extends Usuario{
	private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
	
	
	/**
	 * Metodo constructor de Vecino
	 * @param id -> id del vecino
	 * @param nombre -> nombre del vecino
	 * @param clave -> calve del vecino
	 * @param telefono -> numero de telefono del vecino
	 * @param email -> email del vecino
	 * @param inmueble -> inmueble del vecino
	 */
	public Vecino(int id, String nombre, String clave, String telefono, String email, Inmueble inmueble) { 
		super(id, nombre, clave, telefono, email);
		this.inmuebles.add(inmueble);
	}
	public Vecino(int id, String nombre, String clave, String telefono, String email) { 
		super(id, nombre, clave, telefono, email);
	}
	
	public Vecino(String nombre, String clave, String telefono, String email, Inmueble inmueble) { 
		super(nombre, clave, telefono, email);
		this.inmuebles.add(inmueble);
	}
	public Vecino(String nombre, String clave, String telefono, String email) { 
		super(nombre, clave, telefono, email);
	}
	
	/**
	 * a�ade inmuebles a vecino.
	 *
	 * @param inmueble -> inmueble a a�adir del vecino
	 */
	public void addInmueble(Inmueble inmueble) {
		this.inmuebles.add(inmueble);
	}
	/**
	 * Elimina inmuebles del vecino.
	 *
	 * @param inmueble -> inmueble a eliminar del vecino
	 */
	public void deleteInmueble(Inmueble inmueble) {
		this.inmuebles.remove(inmueble);
	}
	/**
	 * Devuelve una lista con los inmuebles del vecino.
	 *
	 * @return inmuebles
	 */
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	/**
	 * Introduce los inmuebles.
	 *
	 * @param inmuebles -> inmuebles del vecino
	 */
	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}
	
	/**
	 * Devuelve los servicios que tiene el inmueble
	 *
	 * @return servicios
	 */
	public List<Servicio> consultarServicios() {
		return null;
		
	}
}

