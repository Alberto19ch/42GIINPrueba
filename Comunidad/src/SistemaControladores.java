import controlador.*;

/**
 * Clase para manejar los controladores de la aplicacion.
 * 
 */
public class SistemaControladores {  
    ControladorConcepto controladorConcepto;
    ControladorGastos controladorGastos;
    ControladorInmueble controladorInmueble;
    ControladorLiquidacion controladorLiquidacion;
    ControladorProveedor controladorProveedor;
    ControladorServicio controladorServicio;
    ControladorUsuario controladorUsuario;
    
    public SistemaControladores(SistemaDao sistemaDao) {
        
    	this.controladorProveedor = new ControladorProveedor(sistemaDao.daoProveedor);
    	
    	
    }
}
