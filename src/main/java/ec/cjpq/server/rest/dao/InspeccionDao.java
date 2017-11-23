package ec.cjpq.server.rest.dao;

import ec.cjpq.server.rest.bean.InspeccionBean;
import ec.cjpq.server.rest.jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Clase DAO para entidad Inspeccion
 * @author carper
 * 2017-11-22
 */ 
public class InspeccionDao{
	
    final static Logger logger = Logger.getLogger(InspeccionDao.class);

    public void create(InspeccionBean inspeccion) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
        
        String insertSQL = ""; 

        //Generado con PGAdmin y StringBuilder con SQuirel
        //
        //{d '2017-11-22'} para el campo fecha
        //No se cuenta el campo id (hacerlo autonumerico)

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO public.inspeccion( "); 
        sb.append("            contenedor, tamano, chasis, placa, cliente, fecha, agencia, "); 
        sb.append("            vapor, destino, factura, pta_izq, pta_der, pfi_izq, pfi_der, "); 
        sb.append("            ur_izq, ur_der, le_izq, le_der, li_izq, li_der, techo, piso, "); 
        sb.append("            est_inf, est_int, chasis_estado, observaciones, inspector) "); 
        sb.append("    VALUES (?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?); ");

        try{
            dbConnection = JDBCConnection.getDBConnection();
		    dbConnection.setAutoCommit(false);

            ps = dbConnection.prepareStatement(insertSQL);
            
            ps.setString( 1, inspeccion.getContenedor());
            ps.setString( 2, inspeccion.getTamano());
            ps.setString( 3, inspeccion.getChasis());
            ps.setString( 4, inspeccion.getPlaca());
            ps.setString( 5, inspeccion.getCliente());
            ps.setString( 6, inspeccion.getFecha());
            ps.setString( 7, inspeccion.getAgencia());
            ps.setString( 8, inspeccion.getVapor());
            ps.setString( 9, inspeccion.getDestino());
            ps.setString(10, inspeccion.getFactura());
            ps.setString(11, inspeccion.getPta_izq());
            ps.setString(12, inspeccion.getPta_der());
            ps.setString(13, inspeccion.getPfi_izq());
            ps.setString(14, inspeccion.getPfi_der());
            ps.setString(15, inspeccion.getUr_izq());
            ps.setString(16, inspeccion.getUr_der());
            ps.setString(17, inspeccion.getLe_izq());
            ps.setString(18, inspeccion.getLe_der());
            ps.setString(19, inspeccion.getLi_izq());
            ps.setString(20, inspeccion.getLi_der());
            ps.setString(21, inspeccion.getTecho());
            ps.setString(22, inspeccion.getPiso());
            ps.setString(23, inspeccion.getEst_inf());
            ps.setString(24, inspeccion.getEst_int());
            ps.setString(25, inspeccion.getChasis_estado());
            ps.setString(26, inspeccion.getObservaciones());
            ps.setString(27, inspeccion.getInspector());
            
            ps.executeUpdate();

		} catch (Exception e) {
			logger.info( e.getMessage() );
		} finally {
			if (ps != null) 
				ps.close();
			if (dbConnection != null)
				dbConnection.close();
		}

    }
}
