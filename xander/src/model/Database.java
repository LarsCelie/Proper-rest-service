package model;

/**
 * An abstraction of a database.
 * @author Lars
 *
 */
public interface Database {
	 String execute(String sqlStatement);

}
