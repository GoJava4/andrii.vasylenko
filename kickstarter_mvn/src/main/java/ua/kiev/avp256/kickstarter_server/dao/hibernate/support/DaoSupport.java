package ua.kiev.avp256.kickstarter_server.dao.hibernate.support;

import java.util.List;

import org.hibernate.Session;

public interface DaoSupport {
	/**
	 * Obtains the current session.
	 */
	Session getCurrentSession();

	/**
	 * Persists specified entity.
	 *
	 * @param entity
	 *            - ENTITY instance to persist.
	 * 
	 * @throws DataNotFoundException
	 *             when entity is null
	 */
	void persist(Object entity);

	/**
	 * Returns entity with specified Id.
	 *
	 * @param id
	 *            - id of the entity to return.
	 * @param clazz
	 *            - type of the entity.
	 * 
	 * @throws DataNotFoundException
	 *             when there are no entity with current 'id' in DB
	 */
	<ENTITY> ENTITY load(int id, Class<ENTITY> clazz);

	/**
	 * Check result of loading entities list. It's should be not null and not
	 * empty
	 *
	 * @param result
	 *            - list of entities
	 * 
	 * @throws DataNotFoundException
	 *             when result is null or result is empty
	 */
	void check(List<?> result);
}
