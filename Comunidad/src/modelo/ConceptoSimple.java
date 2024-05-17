/**
 * @author Daniel Espinosa
 *
 */
package modelo;

/**
 * Clase ConceptoSimple.
 */
public class ConceptoSimple extends Concepto{

    /**
	 * Metodo constructor de ConceptoSimple
	 * @param descripcion -> descripcion del concepto
	 * @param gasto -> gasto vinculado al concepto
	 * @param servicio -> servicio vinculado al concepto
	 */
	public ConceptoSimple(int id, String descripcion, Servicio servicio) {
		super(id, descripcion, servicio);

	}

}
