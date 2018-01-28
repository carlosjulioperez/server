package ec.cjpq.server.rest.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import java.util.List;

import junit.framework.TestCase;

import ec.cjpq.server.rest.model.entity.AgenciaNaviera;
import ec.cjpq.server.rest.model.entity.Cliente;
import ec.cjpq.server.rest.model.entity.Destino;
import ec.cjpq.server.rest.model.entity.Inspeccion;
import ec.cjpq.server.rest.model.entity.Usuario;

/**
 * Unit test for simple App.
 * https://memorynotfound.com/unit-test-jpa-junit-in-memory-h2-database/
 * https://stackoverflow.com/questions/19848794/jpa-connection-closed-with-entitymanager
 * http://javanotepad.blogspot.com/2007/06/how-to-close-jpa-entitymanger-in-web.html
 *
 */
public class EntityDaoTest extends TestCase {

	private EntityManager entityManager;

	public void _testInspeccion() {

		entityManager = Persistence.createEntityManagerFactory("entityManager").createEntityManager();
		entityManager.getTransaction().begin();

		Inspeccion obj = new Inspeccion();
        obj.setContenedor ( "ABC123" );
        obj.setTamano     ( "40" );
        obj.setChasis     ( "GYE040" );
        obj.setPlaca      ( "PLACA01" );
		entityManager.persist(obj);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

    public void testAgenciaNaviera(){
        for (AgenciaNaviera o: new AgenciaNavieraDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }
    
    public void testCliente(){
        for (Cliente o: new ClienteDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }

    public void testDestino(){
        for (Destino o: new DestinoDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }

    public void testUsuario(){
        for (Usuario o: new UsuarioDao().getAll() ){
            System.out.println(o.getNombre());
        }
    }
}

