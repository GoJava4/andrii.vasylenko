package kickstarter.dao;

import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public interface Dao<T> {
	/**
	 * add entity to appropriate table of DB
	 */
	void addEntity(T entity) throws DataBaseException, IncorrectInputException;

	/**
	 * get list of entities from appropriate table of DB; parameters depend on
	 * implementation
	 */
	List<T> getEntities(Object... parameters) throws DataBaseException, IncorrectInputException;

	/**
	 * get entity from appropriate table of DB; parameters depend on
	 * implementation
	 */
	T getEntity(Object... parameters) throws DataBaseException, IncorrectInputException;
}
