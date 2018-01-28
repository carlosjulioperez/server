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

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Inspección JavaBean
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2017-11-03, 26
 * 2017-12-04
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
   
	@POST
	@Path("/list/{field}/{value}")
	@Produces(MediaType.APPLICATION_JSON)
    public List<InspeccionBean> toList(
            @PathParam("field") String field, 
            @PathParam("value") String value){
        List<InspeccionBean> result = null;
        try{
            result = new InspeccionDao().findByField(field, value);
        } catch (Exception e) {
            logger.info( e.getMessage() );
        }

        return result;
    }
	
    @POST
	@Path("/get/{value}")
	@Produces(MediaType.APPLICATION_JSON)
    public InspeccionBean get(@PathParam("value") Integer value){
        InspeccionBean result = null;
        try{
            result = new InspeccionDao().findById(value);
        } catch (Exception e) {
            logger.info( e.getMessage() );
        }

        return result;
    }
}
