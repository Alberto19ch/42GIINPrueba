/**
 * @author Daniel Espinosa
 *
 */
package modelo;

import java.util.List;
import java.util.ArrayList;
/**
 * Clase Inmueble.
 */
public class Inmueble {

	private int id;
	private String planta;
	private String numero;
	private int metrosCuadrados;
	private List<Servicio> serviciosInmueble = new ArrayList<Servicio>();
	/**
	 * Metodo constructor de Inmueble
	 * @param planta -> planta del edificio
	 * @param numero -> numero de puerta.
	 * @param metrosCuadrados -> superficie que tiene el inmueble
	 */
	public Inmueble(int id, String planta, String numero, int metrosCuadrados) {
		this.id = id;
		this.planta= planta;
		this.numero=numero;
		this.metrosCuadrados=metrosCuadrados;
	}
	/**
	 * Metodo constructor de Inmueble
	 * @param planta -> planta del edificio
	 * @param numero -> numero de puerta.
	 * @param metrosCuadrados -> superficie que tiene el inmueble
	 * @param serviciosInmueble -> lista de servicios que usa de forma opcional o obligatoria
	 */
	public Inmueble(int id, String planta, String numero, int metrosCuadrados, List<Servicio> serviciosInmueble) {
		this.id = id;
		this.planta= planta;
		this.numero=numero;
		this.metrosCuadrados=metrosCuadrados;
		this.serviciosInmueble = serviciosInmueble;

	}
	public Inmueble(String planta, String numero,int metrosCuadrados) {
		this.planta= planta;
		this.numero=numero;
		this.metrosCuadrados=metrosCuadrados;
	}
	
	/**
	 * Devuelve id.
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Devuelve el numero de planta.
	 *
	 * @return planta
	 */
	public String getPlanta() {
		return planta;
	}
	
	/**
	 * Introduce el numero de planta.
	 *
	 * @param planta -> planta del inmueble
	 */
	public void setPlanta(String planta) {
		this.planta = planta;
	}
	
	/**
	 * Devuelve el numero de puerta
	 *
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Introduce el numero de puerta
	 *
	 * @param numero -> numero de puerta
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Devuelve los metros cuadrados del inmueble
	 *
	 * @return metrosCuadrados
	 */
	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}
	
	/**
	 * Introduce metros cuadrados del inmueble
	 *
	 * @param metrosCuadrados -> metros cuadrados del inmueble
	 */
	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	
	/**
	 * Devuelve la lista de servicios del inmueble
	 *
	 * @return lista de servicios del inmueble
	 */
	public List<Servicio> getServiciosInmueble() {
		return serviciosInmueble;
	}
	
	/**
	 * Introduce los servicios al inmueble
	 *
	 * @param serviciosInmueble -> lista de servicios para el inmueble
	 */
	// Sobreescribe los servicios existentes
	public void setServiciosInmueble(List<Servicio> serviciosInmueble) {
		this.serviciosInmueble=serviciosInmueble;
	}
	
	/**
	 * Añade un servicio al inmueble
	 *
	 * @param servicioInmueble -> servicio para añadir
	 */
	// Añade servicios a los que ya tiene
	public void addServicioInmueble(Servicio servicioInmueble) {
		this.serviciosInmueble.add(servicioInmueble);
	}
	/**
	 * Elimina un servicio al inmueble
	 *
	 * @param servicioInmueble -> servicio para añadir
	 */
	// Añade servicios a los que ya tiene
	public void delServicioInmueble(Servicio servicioInmueble) {
		this.serviciosInmueble.remove(servicioInmueble);
	}
	
	/**
	 * Calcula el coste total por inmueble y lo devuelve.
	 *
	 * @return coste total de los servicios del inmueble
	 */
	// devuelve el coste total de los servicios suscritos al inmueble
	public Integer getCosteServicios() {
		int costeTotal= 0;
		for (Servicio servicio:serviciosInmueble)
			costeTotal += servicio.getCoste()*metrosCuadrados;
		return costeTotal;
	}
		
}


