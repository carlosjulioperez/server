package ec.cjpq.server.rest.service;

import ec.cjpq.server.rest.bean.InspeccionBean;
import ec.cjpq.server.rest.dao.InspeccionDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

/**
 * Inspección JavaBean
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2017-11-03, 26
 *
 * http://www.javasavvy.com/rest-jersey-maven-json-tutorial/
 */
@Path("/inspeccion")
public class InspeccionService{

	final static Logger logger = Logger.getLogger(InspeccionService.class);

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public InspeccionBean add(InspeccionBean inspeccion){

        try{
            Long secuencial = new InspeccionDao().create(inspeccion);
            inspeccion.setId( secuencial.toString() );
            //logger.info(inspeccion.toString());
        } catch (Exception e) {
            logger.info( e.getMessage() );
        }

        return inspeccion;
    }

}
