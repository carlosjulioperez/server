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
 * 2017-12-02 Formato de fecha
 */ 
public class Configuracion{ 
	private static String[] arreglo;

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
        	Properties prop = new Properties();
			prop.load(resourceStream);

            arreglo = new String[] {
                prop.getProperty("DB_DRIVER"),
                prop.getProperty("DB_URL"),
                prop.getProperty("DB_USERNAME"),
                prop.getProperty("DB_PASSWORD"),
                prop.getProperty("FORMAT_DATE")
            };
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    public static Map toMap(){
        Map<String, Object> obj = new HashMap<>();
        obj.put("dbDriver"   , arreglo[0]);
        obj.put("dbURL"      , arreglo[1]);
        obj.put("dbUsername" , arreglo[2]);
        obj.put("dbPassword" , arreglo[3]);
        obj.put("dateFormat" , arreglo[4]);

        return obj;
    }
}
