package ec.cjpq.server.rest.dao;

import ec.cjpq.server.rest.bean.InspeccionBean;
import ec.cjpq.server.rest.jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/**
 * Clase DAO para entidad Inspeccion
 * @author carper
 * 2017-11-22
 * https://www.mkyong.com/jdbc/jdbc-transaction-example/
 * https://stackoverflow.com/questions/241003/how-to-get-a-value-from-the-last-inserted-row
 */ 
public class InspeccionDao{
	
    final static Logger logger = Logger.getLogger(InspeccionDao.class);

    public Long create(InspeccionBean inspeccion) throws SQLException {

        Long secuencial = null;
		Connection dbConnection = null;
		PreparedStatement ps = null;
        
        String insertSQL = ""; 

        //Generado con PGAdmin y StringBuilder con SQuirel
        //
        //{d '2017-11-22'} para el campo fecha
        //No se cuenta el campo id (hacerlo autonumerico)

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO inspeccion( "); 
        sb.append("            contenedor, tamano, chasis, placa, cliente, fecha, agencia, "); 
        sb.append("            vapor, destino, factura, pta_izq, pta_der, pfi_izq, pfi_der, "); 
        sb.append("            ur_izq, ur_der, le_izq, le_der, li_izq, li_der, techo, piso, "); 
        sb.append("            est_inf, est_int, chasis_estado, observaciones, inspector) "); 
        sb.append("    VALUES (?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?, ?) RETURNING id");

        try{
            dbConnection = JDBCConnection.getDBConnection();
		    dbConnection.setAutoCommit(false);

            ps = dbConnection.prepareStatement( sb.toString() );

            SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd" );
            java.util.Date myDate = format.parse( inspeccion.getFecha() );  // Notice the ".util." of package name.
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            
            ps.setString ( 1, inspeccion.getContenedor());
            ps.setString ( 2, inspeccion.getTamano());
            ps.setString ( 3, inspeccion.getChasis());
            ps.setString ( 4, inspeccion.getPlaca());
            ps.setString ( 5, inspeccion.getCliente());
            ps.setDate   ( 6, sqlDate);
            ps.setString ( 7, inspeccion.getAgencia());
            ps.setString ( 8, inspeccion.getVapor());
            ps.setString ( 9, inspeccion.getDestino());
            ps.setString (10, inspeccion.getFactura());

            ps.setBoolean(11, Boolean.parseBoolean(inspeccion.getPta_izq()));
            ps.setBoolean(12, Boolean.parseBoolean(inspeccion.getPta_der()));
            ps.setBoolean(13, Boolean.parseBoolean(inspeccion.getPfi_izq()));
            ps.setBoolean(14, Boolean.parseBoolean(inspeccion.getPfi_der()));
            ps.setBoolean(15, Boolean.parseBoolean(inspeccion.getUr_izq()));
            ps.setBoolean(16, Boolean.parseBoolean(inspeccion.getUr_der()));
            ps.setBoolean(17, Boolean.parseBoolean(inspeccion.getLe_izq()));
            ps.setBoolean(18, Boolean.parseBoolean(inspeccion.getLe_der()));
            ps.setBoolean(19, Boolean.parseBoolean(inspeccion.getLi_izq()));
            ps.setBoolean(20, Boolean.parseBoolean(inspeccion.getLi_der()));
            ps.setBoolean(21, Boolean.parseBoolean(inspeccion.getTecho()));
            ps.setBoolean(22, Boolean.parseBoolean(inspeccion.getPiso()));
            ps.setBoolean(23, Boolean.parseBoolean(inspeccion.getEst_inf()));
            ps.setBoolean(24, Boolean.parseBoolean(inspeccion.getEst_int()));
            ps.setBoolean(25, Boolean.parseBoolean(inspeccion.getChasis_estado()));

            ps.setString (26, inspeccion.getObservaciones());
            ps.setString (27, inspeccion.getInspector());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next() ){
                secuencial = rs.getLong(1);
                dbConnection.commit();
            }

        } catch (Exception e) {
            logger.info( e.getMessage() );
            dbConnection.rollback();
        } finally {
            if (ps != null) 
                ps.close();
            if (dbConnection != null)
                dbConnection.close();
        }
        
        return secuencial;
    }
}
