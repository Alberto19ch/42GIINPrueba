

import modelo.ConfiguracionDB;
import modelo.DAOConcepto;
import modelo.DAOGastos;
import modelo.DAOInmueble;
import modelo.DAOLiquidacion;
import modelo.ConexionDB;
import modelo.DAOProveedor;
import modelo.DAOServicio;
import modelo.DAOUsuario;

import java.io.IOException;
import java.sql.SQLException;

public class SistemaDao {
	public ConfiguracionDB configuracion;
	public ConexionDB db;
	DAOProveedor daoProveedor;
	public DAOGastos daoGastos;
	public DAOServicio daoServicio;
	public DAOConcepto daoConcepto;
    public DAOUsuario daoUsuario;
    public DAOInmueble daoInmueble;
    public DAOLiquidacion daoLiquidacion;

    public SistemaDao() throws IOException, SQLException {
        // Cargar archivo de configuracion para la conexion a la base de datos
        this.configuracion = new ConfiguracionDB();
        this.db =  ConexionDB.getInstance(configuracion);
        this.daoProveedor = new DAOProveedor(db,"proveedor");
        this.daoGastos = new DAOGastos(db, "gastos", this.daoProveedor, this.daoConcepto);
        this.daoServicio = new DAOServicio(db, "servicio", this.daoGastos);
        this.daoConcepto = new DAOConcepto(db, "concepto", this.daoServicio);
        this.daoInmueble = new DAOInmueble(db, "inmueble", this.daoServicio);
        this.daoUsuario = new DAOUsuario(db, "usuario", this.daoInmueble);
        this.daoLiquidacion = new DAOLiquidacion(db, "liquidacion");
    }
}
