package ec.cjpq.server.rest.model.entity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import ec.cjpq.server.rest.model.entity.Inspeccion;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private EntityManager entityManager;

	public void testInspeccion() {

		entityManager = Persistence.createEntityManagerFactory("entityManager")
				.createEntityManager();

		entityManager.getTransaction().begin();

		Inspeccion obj = new Inspeccion();
        obj.setContenedor ( "ABC123" );
        obj.setTamano     ( "40" );
        obj.setChasis     ( "GYE040" );
        obj.setPlaca      ( "GYE040" );
		entityManager.persist(obj);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}

