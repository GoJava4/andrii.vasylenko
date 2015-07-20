package ua.kiev.avp256.kickstarter_server.dao;

public interface GenericDao<ENTITY> {
	/**
	 * Persists specified entity.
	 *
	 * @param entity
	 *            - ENTITY instance to persist.
	 * 
	 * @throws DataNotFoundException
	 *             when entity is null
	 */
	void persist(ENTITY entity);

	/**
	 * Returns entity with specified Id.
	 *
	 * @param id
	 *            - id of the entity to return.
	 * 
	 * @throws DataNotFoundException
	 *             when there are no entity with current 'id' in DB
	 */
	ENTITY load(int id);
}
