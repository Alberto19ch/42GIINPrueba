import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Concepto;
import modelo.Gastos;
import modelo.Inmueble;
import modelo.Proveedor;
import modelo.Servicio;
import modelo.Vecino;
import modelo.Administrador;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Arrancando Aplicacion");
            SistemaDao sistemaDao = new SistemaDao();
            SistemaControladores sistemaControlador = new SistemaControladores(sistemaDao);
            
            //Proveedor nacho = sistemaDao.daoProveedor.insertar(new Proveedor("nacho", "915346524", "calle del medio", "nacho@mgail.com"));
            /**
            Proveedor nacho = sistemaControlador.controladorProveedor.insertarProveedor("nachoooo", "915346524", "calle del medio", "nacho@mgail.com");
            Gastos g = sistemaDao.daoGastos.insertar(new Gastos(100, Date.valueOf("1986-12-24") , Date.valueOf("1986-12-24"), nacho, "ruta imagen")); 
            System.out.println(g.getFechaPago().toString());
            g.setFechaPago(Date.valueOf("1986-12-25"));
            sistemaDao.daoGastos.actualizar(g);
            System.out.println(nacho.getNombre());
           */
            /**
            Vecino v = sistemaDao.daoUsuario.insertar(new Vecino("vecino1","123456","91654346", "vacino1@gmail.com"));
            System.out.println(v.getEmail());
            Inmueble i = sistemaDao.daoInmueble.insertar(new Inmueble("primero", "segunda planta", 214));
            sistemaDao.daoUsuario.añadirInmueble(v, i);
            System.out.println(v.getInmuebles());
            sistemaDao.daoUsuario.eliminarInmueble(v, i);
            System.out.println(v.getEmail());
            System.out.println(v.getInmuebles());
            */
            /**
             * 
            Vecino v = sistemaDao.daoUsuario.insertar(new Vecino("vecino1","123456","91654346", "vacino1@gmail.com"));
            Inmueble i = sistemaDao.daoInmueble.insertar(new Inmueble("primero", "segunda planta", 214));
            Inmueble i2 = sistemaDao.daoInmueble.insertar(new Inmueble("primero2", "segunda2 plant2", 2142));
            sistemaDao.daoUsuario.añadirInmueble(v, i);
            sistemaDao.daoUsuario.añadirInmueble(v, i2);
            */
            /**
            Inmueble inm = sistemaDao.daoInmueble.obtenerRegistro(8);
        	System.out.println(inm.getMetrosCuadrados());
            
            Vecino v = sistemaDao.daoUsuario.obtenerRegistroV(11);
            List<Inmueble> li = sistemaDao.daoInmueble.obtenerRegistros();
            for(Inmueble i : li) {
            	System.out.println(i.getMetrosCuadrados());
            }
            
            List<Vecino> vs = sistemaDao.daoUsuario.obtenerRegistrosV();
            for(Vecino i : vs) {
            	System.out.println(i.getId());
            }
            */
            Inmueble i = sistemaDao.daoInmueble.obtenerRegistro(6);
            Vecino v = sistemaDao.daoUsuario.obtenerRegistroV(10);
            Servicio s = sistemaDao.daoServicio.obtenerRegistro(7);
            //sistemaDao.daoInmueble.añadirServicio(i, s);
            //Proveedor jose = sistemaControlador.controladorProveedor.insertarProveedor("jose luis", "915343324", "calle del centro derecha", "jl@mgail.com");
            //Gastos g = sistemaDao.daoGastos.insertar(new Gastos(1000, Date.valueOf("1997-10-24") , Date.valueOf("1998-12-24"), jose, "ruta imagenaux")); 
            //Servicio s = sistemaDao.daoServicio.insertar(new Servicio("servico hola holita", true, 52, g));           
            //System.out.println(s.getGasto().getProveedor().getdireccion());
            
            
            for(Inmueble inmueble : v.getInmuebles()) {
            	System.out.println("id del inmueble: " + inmueble.getId());
            	for(Servicio servicio: inmueble.getServiciosInmueble()) {
            		System.out.println("Nombre del servicio: "+servicio.getNombre());
            		System.out.println("Ubicacion del archivo: "+servicio.getGasto().getDatosComprobanteGasto());
            		System.out.println("Direccion proveedor: "+servicio.getGasto().getProveedor().getdireccion());
            	}
            }
        } catch (Exception e) {
            System.out.println("Existe un error:");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
}

