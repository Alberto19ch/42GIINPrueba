/**
 * @author Daniel Espinosa
 *
 */
package modelo;
import java.sql.Date;
import java.time.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase Liquidacion.
 */
public class Liquidacion {

	private int id;
	private Date fechaInicio;
	private Date fechaFin;
	private Map<Vecino, LiquidacionVecino> liquidacionesVecinos=new HashMap<Vecino, LiquidacionVecino>();

	/**
	 * Metodo constructor de Liquidacion
	 * @param fechaInicio -> fecha de inicio del periodo de liquidacion
	 * @param fechaFin -> fecha en la que finaliza el periodo de liquidacion
	 */
	public  Liquidacion(int id, Date fechaInicio ,Date fechaFin) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public  Liquidacion(Date fechaInicio,Date fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Devuelve el id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Devuelve la fecha inicio.
	 *
	 * @return  fecha inicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Introduce la fecha inicio.
	 *
	 * @param fechaInicio -> fecha inicio de la liquidacion
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * Devuelve la fecha fin.
	 *
	 * @return  fechaFin-> fecha fin de la liquidacion
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Introduce la fecha fin.
	 *
	 * @param fechaFin -> fecha fin liquidacion
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * Generar la liquidacion de cada uno de los vecinos pasado y lo almacena.
	 *
	 * @param vecionos -> lista de vecinos a liquidar
	 */
	//Crea la liquidacion de cada vecino.
	public void generarLiquidadionVecinos(List<Vecino> vecionos) {
		for (Vecino vecino:vecionos)
		liquidacionesVecinos.put(vecino,new LiquidacionVecino(vecino));
	}
	
	/**
	 * Devuelve la liquidacion del vecino solicitado una vez generada con generarLiquidacionVecinos.
	 *
	 * @param veciono -> vecino del que se solicitad la liquidacion
	 * @return liquidadion vecino
	 */
	// Devuelve la liquidacion de un vecino
	public LiquidacionVecino getLiquidadionVecino(Vecino veciono) {
		return liquidacionesVecinos.get(veciono);
	}
	
}
