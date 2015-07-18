package ua.kiev.avp256.kickstarter_server.dao;

import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

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
