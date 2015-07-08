package kickstarter.dao;

import kickstarter.exception.DataBaseException;

public interface GenericDao<ENTITY> {
	/**
	 * Persists specified entity.
	 *
	 * @param entity
	 *            - ENTITY instance to persist.
	 */
	void persist(ENTITY entity) throws DataBaseException;

	/**
	 * Returns entity with specified Id.
	 *
	 * @param id
	 *            - id of the entity to return.
	 */
	ENTITY load(int id) throws DataBaseException;
}
