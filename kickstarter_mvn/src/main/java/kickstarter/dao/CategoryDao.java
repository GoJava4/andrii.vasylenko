package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public class CategoryDao extends AbstractDao<Category> {

	/**
	 * do not need any parameters
	 */
	@Override
	public List<Category> getEntities(Object... parameters) throws DataBaseException {
		return find("", 0);
	}

	/**
	 * do not need any parameters
	 */
	@Override
	public Category getEntity(Object... parameters) throws DataBaseException {
		return find("", 1).get(0);
	}

	@Override
	protected String getTableName() {
		return Category.class.getSimpleName();
	}
}
