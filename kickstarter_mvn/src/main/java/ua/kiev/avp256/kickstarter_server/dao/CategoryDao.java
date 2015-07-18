package ua.kiev.avp256.kickstarter_server.dao;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public interface CategoryDao extends GenericDao<Category> {
	/**
	 * return all categories from DB
	 */
	List<Category> loadAll() throws DataBaseException;
}
