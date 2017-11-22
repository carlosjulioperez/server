package ec.cjpq.server.rest.dao;

/**
 * Clase DAO para entidad Inspeccion
 * @author carper
 * 2017-11-22
 */ 
public class InspeccionDao{

    public void create(){
		Connection dbConnection = null;
		PreparedStatement ps = null;
        
        String insertSQL = ""; 
        
        dbConnection = getDBConnection();
		dbConnection.setAutoCommit(false);

    }
}
