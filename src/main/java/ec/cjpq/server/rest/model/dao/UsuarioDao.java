package ec.cjpq.server.rest.model.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import ec.cjpq.server.rest.model.entity.Usuario;

import org.apache.log4j.Logger;

/**
 * Usuario Dao
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28
 */
public class UsuarioDao extends EntityDao{
    
    final static Logger logger = Logger.getLogger(UsuarioDao.class);

    public List<Usuario>getAll(){
        
        EntityTransaction tx = em.getTransaction();
        List<Usuario> result = null;

        try{
		    tx.begin();
            result = em.createNamedQuery("Usuario.getAll", Usuario.class).getResultList();
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

