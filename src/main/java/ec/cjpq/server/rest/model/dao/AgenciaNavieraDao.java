package ec.cjpq.server.rest.model.dao;

import java.util.List;

import ec.cjpq.server.rest.model.entity.AgenciaNaviera;

import org.apache.log4j.Logger;

/**
 * AgenciaNaviera Dao
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28
 */
public class AgenciaNavieraDao extends EntityDao{
    
    final static Logger logger = Logger.getLogger(AgenciaNavieraDao.class);

    public List<AgenciaNaviera>getAll(){
        em.getTransaction().begin();
        List<AgenciaNaviera> result = em.createNamedQuery("AgenciaNaviera.getAll", AgenciaNaviera.class).getResultList();
        em.getTransaction().commit();
        return result;
    }
}
