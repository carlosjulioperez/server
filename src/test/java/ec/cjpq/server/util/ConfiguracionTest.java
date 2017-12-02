package ec.cjpq.server.rest.util;

import java.util.Map;

import junit.framework.Assert;
import org.junit.Test;

public class ConfiguracionTest{

    @Test
    public void testNewConfiguracion(){
        
        Map values = Configuracion.toMap();
        System.out.println(values.get("dbDriver"));
        System.out.println(values.get("dateFormat"));

    }
}
