package resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import service.DatabaseService;

public class TargetDatabaseResource {

	DatabaseService databaseService = new DatabaseService();
	
	@POST
	@Path("/{database}/execute")
	public String executeSQLStatement(@PathParam(value = "database") String databaseName,
			@QueryParam("sqlStatement") String sqlStatement) {
		return databaseService.getDatabaseByName(databaseName).execute(sqlStatement);
	}
}
