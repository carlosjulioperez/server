package ec.cjpq.server.rest.model.dao;

import java.util.List;

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
        em.getTransaction().begin();
        List<Usuario> result = em.createNamedQuery("Usuario.getAll", Usuario.class).getResultList();
        em.getTransaction().commit();
        return result;
    }
}

