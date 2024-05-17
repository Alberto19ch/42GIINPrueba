/**
 * @author Daniel Espinosa
 *
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase ConceptoConpuesto.
 */
public class ConceptoMultiple extends Concepto {
	private List<Concepto> subconceptos  = new ArrayList<Concepto>();
	
    /**
	 * Metodo constructor de ConceptoConpuesto
	 * @param descripcion -> descripcion del concepto
	 * @param gasto -> gasto vinculado al concepto
	 * @param servicio -> servicio vinculado al concepto
	 */
	public ConceptoMultiple(int id, String descripcion, Servicio servicio) {
		super(id, descripcion, servicio);

	}
	/**
	 * Devuelve la lista de subconceptos.
	 *
	 * @return subconceptos 
	 */
	public List<Concepto> getSubconceptos() {
		return subconceptos;
	}
	
	/**
	 * Introduce o Sobreescribe la lista de suBconceptos
	 *
	 * @param subconceptos -> lista de sublineas del concepto
	 */
	public void setSubconceptos(List<Concepto> subconceptos) {
		this.subconceptos = subconceptos;
	}
	
	/**
	 * Añade un subconcepto
	 *
	 * @param subconcepto -> Sublinea del concepto
	 */
	public void addSubconceptos(Concepto subconcepto) {
		this.subconceptos.add(subconcepto);
	}
    

}
