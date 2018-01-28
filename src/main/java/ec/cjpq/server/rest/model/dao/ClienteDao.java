package ec.cjpq.server.rest.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import java.util.List;

import ec.cjpq.server.rest.model.entity.Cliente;

/**
 * Cliente Dao
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-27
 */
public class ClienteDao{

	private EntityManager entityManager;

    public List<Cliente>getAll(){

        List<Cliente> result = null;

		entityManager = Persistence.createEntityManagerFactory("entityManager").createEntityManager();
		entityManager.getTransaction().begin();

        result = entityManager.createNamedQuery("Cliente.getAll", Cliente.class).getResultList();
        
        entityManager.getTransaction().commit();
		entityManager.close();

        return result;
    }
}
