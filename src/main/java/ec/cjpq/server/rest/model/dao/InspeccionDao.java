package ec.cjpq.server.rest.model.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ec.cjpq.server.rest.model.entity.Inspeccion;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * Inspeccion Dao
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28
 */
public class InspeccionDao extends EntityDao{
    
    final static Logger logger = Logger.getLogger(InspeccionDao.class);

    public Inspeccion add(Inspeccion o){
        
        EntityTransaction tx = em.getTransaction();
        Inspeccion result = null;

        try{
		    tx.begin();
            em.persist(o);
            result = o;
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            logger.warn( e.getMessage() );
        }finally {
            em.close();
        }

        return result;
    }
    
    public Inspeccion findInspeccion(Integer id){
        
        EntityTransaction tx = em.getTransaction();
        Inspeccion result = null;

        try{
		    tx.begin();
            Query query = em.createQuery("SELECT o FROM Inspeccion o WHERE o.id = " + id);
            Inspeccion o = (Inspeccion)query.getSingleResult();
            
            //Inspeccion o = em.find(Inspeccion.class, id);
            result = (Inspeccion)BeanUtils.cloneBean(o);
            //result = o;

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

