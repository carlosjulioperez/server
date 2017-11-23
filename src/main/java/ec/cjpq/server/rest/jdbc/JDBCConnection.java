package ec.cjpq.server.rest.jdbc;

import ec.cjpq.server.rest.util.Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Clase para administrar la conexión JDBC
 * @author carper
 * 2017-11-22
 */ 
public class JDBCConnection{ 

	final static Logger logger = Logger.getLogger(JDBCConnection.class);

    public static Connection getDBConnection() {
        
        Map<String, String> config = Configuracion.toMap();

		Connection dbConnection = null;
		try {
			Class.forName( config.get("dbDriver") );
		} catch (ClassNotFoundException e) {
			logger.info( e.getMessage() );
		}

		try {
			dbConnection = DriverManager.getConnection(config.get("dbURL"), config.get("dbUsername"), config.get("dbPassword"));
			return dbConnection;
		} catch (SQLException e) {
			logger.info( e.getMessage() );
		}
		return dbConnection;
	}

}

