/**
 * @author Daniel Espinosa
 * @author Alberto Granado
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase ConexionDB.
 */
public final class ConexionDB {
	private static  ConexionDB instancia;
	public  Connection con;
	
	/**
	 * Crea un objeto de tipo DriverManager para poner realizar las consultas a la base de datos
	 */
	public ConexionDB(ConfiguracionDB conf) {
		String url = conf.getPropiedad("URL");
		String user = conf.getPropiedad("USER");
		String pwd = conf.getPropiedad("PASS");
		String puerto = conf.getPropiedad("PUERTO");
		String baseDatos = conf.getPropiedad("BASEDATOS");
		try {
			// 1. Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Conexion con la DB
			con = DriverManager.getConnection("jdbc:mysql://"+ url+":"+puerto+"/"+baseDatos+"?serverTimezone=UTC",user, pwd);
	    	}
	    	catch(ClassNotFoundException | SQLException e){
	    		e.printStackTrace();
	    	}
	    	
		
	}
	
	public static ConexionDB getInstance(ConfiguracionDB conf) {
       
			if (instancia == null) {
				instancia = new ConexionDB(conf);
			}
		
        return instancia;
    }
	/**
	 * Metodo para actualizar los datos de un registro de la base de datos.
	 * 
	 * @param consulta -> string que contiene la consulta en sql.
	 * @return int
	 */
	public int actualizar(String consulta) {
		int i = 0;
		try {
			try (java.sql.Statement st = con.createStatement()){
			i = st.executeUpdate(consulta);
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * M�todo para ejecutar consultas que devulven registros de la base de datos. LLama a la funci�n acomodarDatos.
	 * 
	 * @param consulta -> string que contiene la consulta en sql.
	 * @return List
	 */
	public List ejecutar(String consulta) {
		ResultSet rs = null;
		List resultado = new ArrayList();
		try {
			try (java.sql.Statement st = con.createStatement()){
			rs = st.executeQuery(consulta);
			resultado = acomodarDatos(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
		
	}
	
	/**
	 * Funcion para transformar el ResultSet a un map que tiene la forma <nombreCampo, valor>. 
	 * 
	 * @param rs
	 * @return List
	 */
	private List acomodarDatos(ResultSet rs) {
		List renglones = new ArrayList();
		try {
			int cantColumnas = rs.getMetaData().getColumnCount();
			while(rs.next()) {
				Map<String, Object> renglon = new HashMap();
				for(int i = 1; i <= cantColumnas; i++) {
					String nombreCampo = rs.getMetaData().getColumnName(i);
					Object valor = rs.getObject(nombreCampo);
					renglon.put(nombreCampo, valor);
				}
				renglones.add(renglon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return renglones;
	}
	
	
    
	/**
	* Implementa la desconexion de la base de datos.
	* @param con -> es la conexion con la base de datos
	* @exception java.sql.SQLException se produce si ocurre algun error de sql durante la desconexion.
	*/
    public static void desconectar(Connection con) throws SQLException {
            if(con!=null)
            	con.close();
    }
    /**
     * Metodo para obtner el id m�ximo de una tabla en la base de datos, el nombre de la tabla se pasa por argumento. Si la tabla est� vac�a devuelve 0.
     * 
     * @param tabla -> nombre de la tabla a obtner el id maximo.
     * @return int
     */
    public List getUltimo(String tabla) {
    	
    	ResultSet rs = null;
		List resultado = new ArrayList();
    	String s = "SELECT * FROM "+tabla+" ORDER BY id DESC LIMIT 0, 1";
		
		try {
			try (java.sql.Statement st = con.createStatement()){
			rs = st.executeQuery(s);
			resultado = acomodarDatos(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
		
    	
    }
    
}
