package ec.cjpq.server.rest.model.dao;

import ec.cjpq.server.rest.util.Configuracion;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class JPAHibernateTest{

    protected static Map<String,String> config;
    protected static SimpleDateFormat sdf;

    @BeforeClass
    public static void init() throws Exception {
        config = Configuracion.toMap();
        sdf = new SimpleDateFormat( config.get("dateFormat") );
    }

    @AfterClass
    public static void tearDown(){
    }

}
