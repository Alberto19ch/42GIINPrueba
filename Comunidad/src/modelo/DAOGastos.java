/**
 * 
 */
package modelo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Alberto
 *
 */
public class DAOGastos  extends Dao<Gastos> {
	DAOProveedor daoProveedor;
	DAOConcepto daoConcepto;
	
	/**
	 * 
	 * @param db -> conexion a la base de datos
	 * @param nombreTabla -> nombre de la tabla
	 * @param daoP -> DAO de proveedor
	 * @param daoC -> DAO de Concepto
 */
	public DAOGastos(ConexionDB db, String nombreTabla, DAOProveedor daoP, DAOConcepto daoC) {
		super(db, nombreTabla);
		this.daoProveedor = daoP;
		this.daoConcepto = daoC;
	}

	/**
	 * Metodo que inserta un gasto en la base de datos. Segun tenga concepto o no en el momento
	 * 
	 * @param c -> gasto a insertar.
	 * @return Gastos
	 */
	public Gastos insertar(Gastos g){
		String q="";
		if (g.getConcepto() != null) {
			q = "INSERT INTO "+tabla+" (importe,fechaRegistro,fechaPago,proveedor,concepto,datosComprobanteGasto) VALUE('"
					+ g.getImporte() + "', '"
					+ g.getFechaRegistro().toString() + "', '"
					+ g.getFechaPago().toString() +  "', '"
					+ g.getProveedor().getId() +  "', '"
					+ g.getConcepto().getId() +  "', '"
					+ g.getDatosComprobanteGasto() + "')";
		}else {
			q = "INSERT INTO "+tabla+" (importe,fechaRegistro,fechaPago,proveedor,datosComprobanteGasto) VALUE('"
					+ g.getImporte() + "', '"
					+ g.getFechaRegistro().toString() + "', '"
					+ g.getFechaPago().toString() +  "', '"
					+ g.getProveedor().getId() +  "', '"
					+ g.getDatosComprobanteGasto() + "')";
		}
		db.actualizar(q); 
		List<Map> registros = db.getUltimo(tabla);
		Gastos gasto = null;
		for(Map registro : registros) {
			Proveedor p = daoProveedor.obtenerRegistro((int)registro.get("proveedor"));
			if (registro.get("concepto")!=null) {
				Concepto c = daoConcepto.obtenerRegistro((int)registro.get("concepto"));
					gasto = new Gastos((int)registro.get("id"),
							(int)registro.get("importe"),
							(Date)registro.get("fechaRegistro"),
							(Date)registro.get("fechaPago") ,
							p,
							c,
							(String)registro.get("datosComprobanteGasto"));
			}else {
				gasto = new Gastos((int)registro.get("id"),
						(int)registro.get("importe"),
						(Date)registro.get("fechaRegistro"),
						(Date)registro.get("fechaPago") ,
						p,
						(String)registro.get("datosComprobanteGasto"));
			}
		}
		return gasto;
	}
	
	/**
	 * Actualiza los campos de un gasto de la base de datos.
	 * 
	 * @param p -> gasto con los nuevos campos 
	 * @return int
	 */
	public int actualizar(Gastos p) {
		String q = "";
		if (p.getConcepto()==null) {
			q = "UPDATE "+tabla+" SET importe = '"
					+ p.getImporte() + "', fechaRegistro = '"
					+ p.getFechaRegistro().toString() + "', fechaPago = '"
					+ p.getFechaPago().toString() +"', proveedor = '"
					+ p.getProveedor().getId() + "', datosComprobanteGasto = '"
					+ p.getDatosComprobanteGasto() + "' WHERE id = '"
					+ p.getId() +"'";
		}else {
			q = "UPDATE "+tabla+" SET importe = '"
					+ p.getImporte() + "', fechaRegistro = '"
					+ p.getFechaRegistro().toString() + "', fechaPago = '"
					+ p.getFechaPago().toString() +"', proveedor = '"
					+ p.getProveedor().getId() + "', concepto = '"
					+ p.getConcepto().getId() + "', datosComprobanteGasto = '"
					+ p.getDatosComprobanteGasto() + "' WHERE id = '"
					+ p.getId() +"'";
		}
		return db.actualizar(q);
	}
	
	/**
	 * Metodo para buscar registros en la base de datos por id de gastos.
	 * 
	 * @param id -> id para buscar en la base de datos
	 * @return gasto
	 */
	public Gastos obtenerRegistro(int id) {
		String q = "SELECT * FROM "+tabla+" WHERE id = '"
				+ id + "'";
		List<Map> registros = db.ejecutar(q);
		Gastos gasto = null;
		for(Map registro : registros) {
			if(registro.get("concepto")==null) {
				Proveedor p = daoProveedor.obtenerRegistro((int)registro.get("proveedor"));
				gasto = new Gastos((int)registro.get("id"),
						(int)registro.get("importe"),
						 (Date)registro.get("fechaRegistro"),
						(Date) registro.get("fechaPago"),
						p,
						(String)registro.get("datosComprobanteGasto"));
				return gasto;
			}
			Proveedor p = daoProveedor.obtenerRegistro((int)registro.get("proveedor"));
			Concepto c = daoConcepto.obtenerRegistro((int)registro.get("concepto"));
				gasto = new Gastos((int)registro.get("id"),
						(int)registro.get("importe"),
						 (Date)registro.get("fechaRegistro"),
						(Date) registro.get("fechaPago") ,
						p,
						c,
						(String)registro.get("datosComprobanteGasto"));
		}
		return gasto;	
	}
	
	/**
	 * Metodo para obtener todos los registros de gasto,
	 * @return List
	 */
	public List<Gastos> obtenerRegistros() {
		String q = "SELECT * FROM "+tabla;
		List<Map> registros = db.ejecutar(q);
		List<Gastos> lista = new ArrayList();
		for(Map registro : registros) {
			Proveedor p = daoProveedor.obtenerRegistro((int)registro.get("proveedor"));
			Concepto c = daoConcepto.obtenerRegistro((int)registro.get("concepto"));
			Gastos gasto;
			
			gasto = new Gastos((int)registro.get("id"),
					(int)registro.get("importe"),
					(Date)registro.get("fechaRegistro"),
					(Date) registro.get("fechaPago") ,
					p,
					c,
					(String)registro.get("datosComprobanteGasto"));
			lista.add(gasto);
		}
		return lista;
	}
	
	/**
	 * Metodo para eliminar un registro mediante el id.
	 * 
	 * @param id
	 * @return int
	 */
	public int eliminar(int id) {
		String q = "DELETE FROM "+tabla+" WHERE id = '"
				+  id +"'";
		return db.actualizar(q);
	}
}
