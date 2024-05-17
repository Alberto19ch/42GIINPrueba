package modelo;

import java.util.List;

import modelo.ConexionDB;

public abstract class Dao<E> {
	protected ConexionDB db;
	protected String tabla;
	
	public Dao(ConexionDB db, String nombreTabla) {
        this.db = db;
        this.tabla = nombreTabla;
    }
	public abstract E insertar(E elemento);
	public abstract int actualizar(E elemento);
	public abstract E obtenerRegistro (int id);
	public abstract List<E> obtenerRegistros();
	public abstract int eliminar(int id);
}
