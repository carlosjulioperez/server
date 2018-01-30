package ec.cjpq.server.rest.model.dao;

import java.util.List;

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
        em.getTransaction().begin();
        List<Destino> result = em.createNamedQuery("Destino.getAll", Destino.class).getResultList();
        em.getTransaction().commit();
        return result;
    }
}

