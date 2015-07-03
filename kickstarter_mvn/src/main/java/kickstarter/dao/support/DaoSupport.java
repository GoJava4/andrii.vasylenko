package kickstarter.dao.support;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

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
	 * @param criteria
	 *            - the detached Hibernate criteria object.
	 */
	List<T> find(DetachedCriteria criteria) throws DataBaseException;

	/**
	 * return list of entities from table of DB
	 * 
	 * @param query
	 *            - a query expressed in Hibernate's query language
	 * @param maxResults
	 *            - maximum number of rows for result
	 * @param parameters
	 *            - the values of the parameters
	 */
	List<T> find(String query, int maxResults, Object... parameters) throws DataBaseException;
}
