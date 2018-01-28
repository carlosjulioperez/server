package ec.cjpq.server.rest.service;

import ec.cjpq.server.rest.model.dao.AgenciaNavieraDao;
import ec.cjpq.server.rest.model.entity.AgenciaNaviera;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * AgenciaNaviera Rest Service
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28
 *
 * http://www.javasavvy.com/rest-jersey-maven-json-tutorial/
 */
@Path("/agencianaviera")
public class AgenciaNavieraService{
	
    final static Logger logger = Logger.getLogger(AgenciaNavieraService.class);
	
    @POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
    public List<AgenciaNaviera> toList(){
        List<AgenciaNaviera> result = null;
        try{
            result = new AgenciaNavieraDao().getAll();
        } catch (Exception e) {
            logger.warn( e.getMessage() );
        }
        return result;
    }
}
