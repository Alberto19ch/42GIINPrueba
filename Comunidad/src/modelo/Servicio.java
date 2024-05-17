/**
 * @author Daniel Espinosa
 *
 */
package modelo;

/**
 * Clase Servicio.
 */
public class Servicio {

	private int id;
	private String nombre;
	private Boolean esObligatorio;
	private int coste;
	private Gastos gasto;
	
	/**
	 * Metodo constructor de Servicio
	 *
	 * @param nombre -> Nombre del servicio
	 * @param esObligatorio -> define si el servicio es obligatorio
	 * @param coste -> coste por metro cuadrado para el servicio
	 */
	public Servicio (String nombre, Boolean esObligatorio, int coste, Gastos gasto) {
		this.nombre = nombre;
		this.esObligatorio =  esObligatorio;
		this.coste = coste;
		this.gasto = gasto;
	}
	
	public Servicio (int id, String nombre, Boolean esObligatorio, int coste, Gastos gasto) {
		this.id = id;
		this.nombre = nombre;
		this.esObligatorio =  esObligatorio;
		this.coste = coste;
		this.gasto = gasto;
	}


	/**
	 * Devuelve el id.
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Devuelve el nombre.
	 *
	 * @return  nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Introduce el nombre.
	 *
	 * @param nombre -> nombre del servicio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve el valor que define si el servicio es obligatorio.
	 *
	 * @return  esObligatorio
	 */
	public Boolean getEsObligatorio() {
		return esObligatorio;
	}
	
	/**
	 * Introduce el valor que define si el servicio es obligatorio.
	 *
	 * @param esObligatorio ->  obligarodriedad del servicio
	 */
	public void setEsObligatorio(Boolean esObligatorio) {
		this.esObligatorio = esObligatorio;
	}
	
	/**
	 * Introduce el coste.
	 *
	 * @param coste -> coste del servicio pro metro cuadrado
	 */
	public void setCoste(int coste) {
		this.coste = coste;
	}
	
	/**
	 * Introduce el gasto.
	 *
	 * @param gasto -> gasto del servicio
	 */
	public void setGasto(Gastos gasto) {
		this.gasto = gasto;
	}
	
	/**
	 * Devuelve el coste.
	 *
	 * @return coste
	 */
	public int getCoste() {
		return coste;
	}
	
	/**
	 * Devuelve el gasto.
	 *
	 * @return gasto
	 */
	public Gastos getGasto() {
		return gasto;
	}

}
