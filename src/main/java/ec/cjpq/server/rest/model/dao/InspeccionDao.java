package ec.cjpq.server.rest.model.dao;

import java.util.List;

import javax.persistence.Query;

import ec.cjpq.server.rest.model.entity.Inspeccion;

import org.apache.log4j.Logger;

/**
 * Inspeccion Dao
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28, 29
 */
public class InspeccionDao extends EntityDao{
    
    final static Logger logger = Logger.getLogger(InspeccionDao.class);

    public Inspeccion add(Inspeccion o){
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        return o;
    }
    
    public Inspeccion findInspeccion(Integer id){
        em.getTransaction().begin();
        
        //Query query = em.createQuery("SELECT o FROM Inspeccion o WHERE o.id = " + id);
        //Inspeccion o = (Inspeccion)query.getSingleResult();
        
        Inspeccion o = em.find(Inspeccion.class, id);
        em.getTransaction().commit();
        return o;
    }
}

