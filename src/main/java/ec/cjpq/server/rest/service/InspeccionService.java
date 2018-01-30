package ec.cjpq.server.rest.service;

import ec.cjpq.server.rest.model.dao.InspeccionDao;
import ec.cjpq.server.rest.model.dto.InspeccionDto;
import ec.cjpq.server.rest.model.entity.Inspeccion;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * Inspeccion Rest Service
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2018-ene-28
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
    public Inspeccion add(Inspeccion inspeccion){

        Inspeccion o = null;
        try{
            o = new InspeccionDao().add(inspeccion);
        } catch (Exception e) {
            logger.info( e.getMessage() );
        }
        return o;
    }

    @POST
	@Path("/get/{value}")
	@Produces(MediaType.APPLICATION_JSON)
    public InspeccionDto get(@PathParam("value") Integer value){
        InspeccionDto iDto = null;
        try{
            Inspeccion o = new InspeccionDao().findInspeccion(value);
            
            iDto = new InspeccionDto();
            BeanUtils.copyProperties(iDto, o);

            iDto.setClienteId        ( o.getCliente        ( ).getId ( ) );
            iDto.setAgenciaNavieraId ( o.getAgenciaNaviera ( ).getId ( ) );
            iDto.setDestinoId        ( o.getDestino        ( ).getId ( ) );
            iDto.setUsuarioId        ( o.getUsuario        ( ).getId ( ) );

        } catch (Exception e) {
            logger.info( e.getMessage() );
        }

        return iDto;
    }

    /*
    @POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Inspeccion> toList(){
        List<Inspeccion> result = null;
        try{
            result = new InspeccionDao().getAll();
        } catch (Exception e) {
            logger.warn( e.getMessage() );
        }
        return result;
    }
    */
}

