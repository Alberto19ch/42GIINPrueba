/**
 * @author Daniel Espinosa
 *
 */
package modelo;

/**
 * Clase Concepto.
 */
public abstract class Concepto {

    protected int id;
    protected String descripcion;
    protected Servicio servicio;
    

    /**
	 * Metodo constructor de Concepto
	 * @param descripcion -> descrption del concepto
	 * @param servicio -> servicio vinculado al concepto
	 */
    public Concepto ( String descripcion, Servicio servicio){
   
    	this.descripcion = descripcion;
        this.servicio = servicio;
    }
    public Concepto (int id, String descripcion, Servicio servicio){
        this.id=id;
    	this.descripcion = descripcion;
        this.servicio = servicio;
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
	 * Devuelve descripcion.
	 *
	 * @return the descripcion -> descrption del concepto
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Introduce descripcion.
	 *
	 * @param descripcion -> descripcion del concepto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve servicio.
	 *
	 * @return servicio -> servicio vinculado al concepto
	 */
	public Servicio getServicio() {
		return servicio;
	}
	
	/**
	 * Introduce servicio.
	 *
	 * @param servicio ->Referencia a intancia servicio que vinculado al concepto
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	

    
}
