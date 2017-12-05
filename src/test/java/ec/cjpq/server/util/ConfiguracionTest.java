package ec.cjpq.server.rest.util;

import java.util.Map;
import java.util.LinkedHashMap;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Clase JUnit de Configuracion
 * @author carper
 * 2017.12.04
 */
public class ConfiguracionTest{

    //@Test
    public void testNewConfiguracion(){
        
        Map values = Configuracion.toMap();
        System.out.println(values.get("dbDriver"));
        System.out.println(values.get("dateFormat"));

    }

    //https://www.mkyong.com/java8/java-8-foreach-examples/
    @Test
    public void testHashMap(){
        Map <String,String> items = new LinkedHashMap<>();
        items.put("codigo1", "valor1");
        items.put("codigo2", "valor2");
        items.put("codigo3", "valor3");
        items.put("codigo4", "valor4");
        items.put("codigo5", "valor5");

        for (Map.Entry<String, String> entry : items.entrySet()) {
        	System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        //items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
    }
}
