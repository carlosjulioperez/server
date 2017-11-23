package ec.cjpq.server.rest.dao;

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

    public void create() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
        
        String insertSQL = ""; 

        //Generado con PGAdmin y StringBuilder con SQuirel
        //
        //{d '2017-11-22'} para el campo fecha

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO public.inspeccion( "); 
        sb.append("            id, contenedor, tamano, chasis, placa, cliente, fecha, agencia, "); 
        sb.append("            vapor, destino, factura, pta_izq, pta_der, pfi_izq, pfi_der, "); 
        sb.append("            ur_izq, ur_der, le_izq, le_der, li_izq, li_der, techo, piso, "); 
        sb.append("            est_inf, est_int, chasis_estado, observaciones, inspector) "); 
        sb.append("    VALUES (?, ?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?, ?, ?, ?, "); 
        sb.append("            ?, ?, ?, ?, ?); ");

        try{
            dbConnection = JDBCConnection.getDBConnection();
		    dbConnection.setAutoCommit(false);


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
