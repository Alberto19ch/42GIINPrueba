/**
 * @author Antonio Foncubierta
 *
 */
package modelo;

import java.sql.Date;
/**
 * Clase Gastos.
 */
public class Gastos {
    private int id;
    private int importe;
    private Date fechaRegistro;
    private Date fechaPago;
    private Proveedor proveedor;
    private Concepto concepto;
    private String datosComprobanteGasto;

    /**
     * Metodo constructor de Gastos.
     * @param importe -> se refiere al importe del gasto
     * @param fechaRegistro -> se refiere a la fecha la cual se registro dicho gasto
     * @param fechaPago -> se refiere al a fecha la cual se realizo el pago de este gasto.
     * @param proveedor -> se refiere al proveedor al cual esta asociado este Gasto
     * @param concepto -> se refiere al concepto al cual esta asociado este Gasto.
     * @param datosComprobanteGasto -> Ruta en la que se guarda una imagen del comprobante
     */
    public Gastos(int id, int importe, Date fechaRegistro, Date fechaPago, Proveedor proveedor, Concepto concepto, String datosComprobanteGasto){
    	this.id = id;
        this.importe = importe;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.concepto = concepto;
        this.datosComprobanteGasto = datosComprobanteGasto;
    }
    
    public Gastos( int importe, Date fechaRegistro, Date fechaPago, Proveedor proveedor, Concepto concepto, String datosComprobanteGasto){
        this.importe = importe;
        this.fechaRegistro = fechaRegistro;
        this.fechaPago = fechaPago;
        this.proveedor = proveedor;
        this.concepto = concepto;
        this.datosComprobanteGasto = datosComprobanteGasto;
    }
    
    public Gastos(int importe, Date fechaRegistro, Date fechaPago, Proveedor proveedor, String datosComprobanteGasto){
    	 this.importe = importe;
         this.fechaRegistro = fechaRegistro;
         this.fechaPago = fechaPago;
         this.proveedor = proveedor;
         this.datosComprobanteGasto = datosComprobanteGasto;
	}
    
    public Gastos(int id,int importe, Date fechaRegistro, Date fechaPago, Proveedor proveedor,  String datosComprobanteGasto){
    	this.id = id; 
    	this.importe = importe;
         this.fechaRegistro = fechaRegistro;
         this.fechaPago = fechaPago;
         this.proveedor = proveedor;
         this.datosComprobanteGasto = datosComprobanteGasto;
	}
	/**
     * Devuelve el Id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el importe de tipo int
     * @return importe
     */
    public int getImporte() {
        return importe;
    }

    /**
     * Asigna el importe de tipo int
     * @param importe -> se refiere al importe del gasto
     */
    public void setImporte(int importe) {
        this.importe = importe;
    }
    /**
     * Devuelve la FechaRegistro de tipo Date
     * @return fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    /**
     * Asigna la FechaRegistro de tipo Date
     * @param fechaRegistro -> se refiere a la fecha la cual se registro dicho gasto
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    /**
     * Devuelve la FechaPago de tipo Date
     * @return fechaPago
     */
    public Date getFechaPago() {
        return fechaPago;
    }
    /**
     * Asigna la FechaPago de tipo Date
     * @param fechaPago -> se refiere al a fecha la cual se realizo el pago de este gasto.
     */
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    /**
     * Devuelve el proveedor de tipo Proveedor
     * @return proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }
    /**
     * Asigna el proveedor de tipo Proveedor
     *  @param  proveedor -> se refiere al proveedor al cual esta asociado este Gasto
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    /**
     * Devuelve el concepto de tipo Concepto
     * @return concepto
     */
    public Concepto getConcepto() {
        return concepto;
    }  
    /**
     * Asigna el concepto de tipo Proveedor
     *  @param  concepto -> se refiere al concepto al cual esta asociado este Gasto
     */
    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }    
    /**
     * Devuelve el datosComprobanteGasto es la ruta en la que se guarda una imagen del comprobante
     * @return datosComprobanteGasto
     */
    public String getDatosComprobanteGasto() {
        return datosComprobanteGasto;
    }
	/**
	 * Introduce el datosComprobanteGasto.
	 * @param  datosComprobanteGasto -> Ruta en la que se guarda una imagen del comprobante
	 */
    public void setDatosComprobanteGasto(String datosComprobanteGasto) {
        this.datosComprobanteGasto = datosComprobanteGasto;
    }

}
