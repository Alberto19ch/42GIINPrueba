package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Este es el código de la clase ConfigService, que se encarga de leer el archivo de configuración "config.properties".
 * La clase utiliza la clase Properties de Java para leer las claves y valores del archivo y almacenarlos en un objeto Properties.
 * La función getProperty se utiliza para recuperar el valor de una propiedad específica.
 */
public class ConfiguracionDB {
    private final Properties CONFDB;

    /**
     * Del archivo "config.properties" se leen las clave=valor
     *
     * @throws IOException
     */
    public ConfiguracionDB() throws IOException {
        this.CONFDB = new Properties();
        this.CONFDB.load(new FileInputStream("Configuracion"));
    }

    public String getPropiedad(String key) {
        return this.CONFDB.getProperty(key);
    }
}
