package ec.cjpq.server.rest.service;

import ec.cjpq.server.rest.model.dao.UsuarioDao;
import ec.cjpq.server.rest.model.entity.Usuario;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Usuario Rest Service
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28
 *
 * http://www.javasavvy.com/rest-jersey-maven-json-tutorial/
 */
@Path("/usuario")
public class UsuarioService{
	
    final static Logger logger = Logger.getLogger(UsuarioService.class);
	
    @POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> toList(){
        List<Usuario> result = null;
        try{
            result = new UsuarioDao().getAll();
        } catch (Exception e) {
            logger.warn( e.getMessage() );
        }
        return result;
    }
}
