package ua.kiev.avp256.kickstarter_server.dao;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.entity.Category;

public interface CategoryDao extends GenericDao<Category> {
	/**
	 * return all categories from DB
	 * 
	 * @throws DataNotFoundException
	 *             when there are no any category in DB
	 */
	List<Category> loadAll();
}
