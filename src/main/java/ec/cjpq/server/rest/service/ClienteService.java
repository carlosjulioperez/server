package ec.cjpq.server.rest.service;

import ec.cjpq.server.rest.model.dao.ClienteDao;
import ec.cjpq.server.rest.model.entity.Cliente;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Cliente Rest Service
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-24
 *
 * http://www.javasavvy.com/rest-jersey-maven-json-tutorial/
 */
@Path("/cliente")
public class ClienteService{
	
    final static Logger logger = Logger.getLogger(ClienteService.class);
	
    @POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> toList(){
        List<Cliente> result = null;
        try{
            result = new ClienteDao().getAll();
        } catch (Exception e) {
            logger.info( e.getMessage() );
        }
        return result;
    }
}
