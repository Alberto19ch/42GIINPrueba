/**
 * @author Daniel Espinosa
 *
 */
package modelo;

import java.util.HashMap;
import java.util.Map;


/**
 * Clase LiquidacionVecino.
 */
public class LiquidacionVecino {
	private Vecino vecino;
	//private Map<Inmueble, Integer> costeInmueble=new HashMap<Inmueble, Integer>();
	private int costeTotal=0;

	/**
	 * Metodo constructor de LiquidacionVecino genera el coste total y el coste por inmueble
	 * @param vecino -> es el propietario de el inmueble y posee toda la información para poder generar la liquidación
	 */
	public LiquidacionVecino(Vecino vecino) {
		this.vecino = vecino;
		for (Inmueble inmueble:this.vecino.getInmuebles()) {
			//costeInmueble.put(inmueble,inmueble.getCosteServicios());
			costeTotal +=inmueble.getCosteServicios();
		}
			
	}
	
	/**
	 * Devuelve el coste total de la liquidacion del usuario
	 *
	 * @return coste total de la liquidacion
	 */
	public int getCosteTotalLiquidacion() {
		return costeTotal;
	}
	
	/**
	 *
	 * @param inmueble -> inmueble del que se calcula la liquidacion
	 * @return coste total de la liquidacion del inmueble
	 */
	public int getCosteInmuebleLiquidacion(Inmueble inmueble) {
		return inmueble.getCosteServicios();
	}

}
