package ec.cjpq.server.rest.model.entity;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import ec.cjpq.server.rest.model.entity.Cliente;
import ec.cjpq.server.rest.model.entity.Inspeccion;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

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

    public void testCliente(){

		entityManager = Persistence.createEntityManagerFactory("entityManager").createEntityManager();
		entityManager.getTransaction().begin();
		
        for (Cliente cliente: entityManager.createNamedQuery("Cliente.getAll", Cliente.class).getResultList() ){
            System.out.println(cliente.getNombre());
        }
        
        entityManager.getTransaction().commit();
		entityManager.close();
    }
}

