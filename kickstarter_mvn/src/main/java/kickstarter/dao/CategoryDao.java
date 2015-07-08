package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public interface CategoryDao extends GenericDao<Category> {
	/**
	 * return all categories from DB
	 */
	List<Category> loadAll() throws DataBaseException;
}
