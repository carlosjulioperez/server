package ec.cjpq.server.rest.model.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import ec.cjpq.server.rest.model.entity.Cliente;

import org.apache.log4j.Logger;

/**
 * Cliente Dao
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-27
 */
public class ClienteDao extends EntityDao{
    
    final static Logger logger = Logger.getLogger(ClienteDao.class);

    public List<Cliente>getAll(){
        
        EntityTransaction tx = em.getTransaction();
        List<Cliente> result = null;

        try{
		    tx.begin();
            result = em.createNamedQuery("Cliente.getAll", Cliente.class).getResultList();
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            logger.warn( e.getMessage() );
        }finally {
            em.close();
        }

        return result;
    }
}

