package kickstarter.dao.support;

import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public interface DaoSupport<T> {
	/**
	 * insert entity to appropriate table of DB
	 * 
	 * @param entity
	 *            the transient instance to persist
	 */
	void addEntity(T entity) throws IncorrectInputException;

	/**
	 * return list of entities from table of DB
	 * 
	 * @param tableName
	 *            - name of DB table
	 * @param condition
	 *            - additional condition for 'SELECT' query
	 * @param maxResults
	 *            - the maximum number of rows in result
	 * @param parameters
	 *            - values which uses in condition
	 */
	List<T> find(String tableName, String condition, int maxResults, Object... parameters) throws DataBaseException;
}
