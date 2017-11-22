package ec.cjpq.server.rest.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Clase Configuracion siguiendo el patrón Singleton
 * @author carper
 * 2017-08-28, 31
 * 2017-09-07
 */ 
public class Configuracion{ 
	private static String dbDriver;
	private static String dbURL;
	private static String dbUsername;
	private static String dbPassword;

    // Crear un objeto de Configuracion
    public static Configuracion instancia = new Configuracion();

    // Obtener el único objeto disponible
    public static Configuracion getInstancia(){
        return instancia;
    }

    // Hacer el constructor privado para que esta clase no pueda ser instanciada
    private Configuracion(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try(InputStream resourceStream = loader.getResourceAsStream("config.properties")) {
        	Properties propiedades = new Properties();
			propiedades.load(resourceStream);

			dbDriver   = propiedades.getProperty("DB_DRIVER");
			dbURL      = propiedades.getProperty("DB_URL");
			dbUsername = propiedades.getProperty("DB_USERNAME");
			dbPassword = propiedades.getProperty("DB_PASSWORD");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    public static Map toMap(){
        Map<String, Object> obj = new HashMap<>();
        obj.put("dbDriver"   , dbDriver  );
        obj.put("dbURL"      , dbURL     );
        obj.put("dbUsername" , dbUsername);
        obj.put("dbPassword" , dbPassword);
        return obj;
    }
}
