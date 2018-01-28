package ec.cjpq.server.rest.model.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import ec.cjpq.server.rest.model.entity.Destino;

import org.apache.log4j.Logger;

/**
 * Destino Dao
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28
 */
public class DestinoDao extends EntityDao{
    
    final static Logger logger = Logger.getLogger(DestinoDao.class);

    public List<Destino>getAll(){
        
        EntityTransaction tx = em.getTransaction();
        List<Destino> result = null;

        try{
		    tx.begin();
            result = em.createNamedQuery("Destino.getAll", Destino.class).getResultList();
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

