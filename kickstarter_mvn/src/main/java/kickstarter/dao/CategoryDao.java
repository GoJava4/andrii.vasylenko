package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public interface CategoryDao {
	/**
	 * return all categories from DB
	 */
	List<Category> getCategories() throws DataBaseException;
}
