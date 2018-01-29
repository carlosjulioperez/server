package ec.cjpq.server.rest.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import java.util.List;

import ec.cjpq.server.rest.model.entity.AgenciaNaviera;
import ec.cjpq.server.rest.model.entity.Cliente;
import ec.cjpq.server.rest.model.entity.Destino;
import ec.cjpq.server.rest.model.entity.Inspeccion;
import ec.cjpq.server.rest.model.entity.Usuario;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Unit test for simple App.
 * https://memorynotfound.com/unit-test-jpa-junit-in-memory-h2-database/
 * https://stackoverflow.com/questions/19848794/jpa-connection-closed-with-entitymanager
 * http://javanotepad.blogspot.com/2007/06/how-to-close-jpa-entitymanger-in-web.html
 *
 */
public class EntityDaoTest extends JPAHibernateTest{

    final static Logger logger = Logger.getLogger(EntityDaoTest.class);

    //@Test
	public void testAddInspeccion() {

        try{
        Cliente c = new Cliente();
        c.setId(1);

        AgenciaNaviera a = new AgenciaNaviera(); 
        a.setId(1);

        Destino d = new Destino();
        d.setId(1);

        Usuario u = new Usuario();
        u.setId(1);

		Inspeccion o = new Inspeccion();
        o.setContenedor     ( "ABC123" );
        o.setTamano         ( "40" );
        o.setChasis         ( "GYE040" );
        o.setPlaca          ( "PLACA01" );
        o.setCliente        ( c );
        
        java.util.Date myDate = sdf.parse( "2017/11/03" );  // Notice the ".util." of package name.
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        o.setFecha          ( sqlDate );
        
        o.setAgenciaNaviera ( a );
        o.setVapor          ( "VAPOR" ); 
        o.setDestino        ( d );
        o.setFactura        ( "FAC001" );

        o.setObservaciones  ( "PRUEBAS" );
        o.setUsuario        ( u );
        
        System.out.println( new InspeccionDao().add(o) );
        } catch (Exception e) {
            logger.warn( e.getMessage() );
        }
	}
    
    @Test
    public void testFindInspeccion(){
        Inspeccion o = new InspeccionDao().findInspeccion(2);
        System.out.println( o.getFecha() );
        System.out.println( o.getCliente().getNombre() );
    }

    public void _testAgenciaNaviera(){
        for (AgenciaNaviera o: new AgenciaNavieraDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }
    
    public void _testCliente(){
        for (Cliente o: new ClienteDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }

    public void _testDestino(){
        for (Destino o: new DestinoDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }

    public void _testUsuario(){
        for (Usuario o: new UsuarioDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }
}

