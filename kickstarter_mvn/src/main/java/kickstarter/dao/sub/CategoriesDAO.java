package kickstarter.dao.sub;

import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public interface CategoriesDAO {
	/**
	 * add new Category to DB
	 */
	void addCategory(String name) throws DataBaseException, SQLException;

	/**
	 * return all Categories from DB
	 */
	List<Category> getCategories() throws DataBaseException, SQLException;

	/**
	 * return Category from DB by id
	 */
	Category getCategory(int id) throws DataBaseException, SQLException;

	/**
	 * create table Categories in DB
	 */
	void createTableCategories() throws DataBaseException, SQLException;
}
