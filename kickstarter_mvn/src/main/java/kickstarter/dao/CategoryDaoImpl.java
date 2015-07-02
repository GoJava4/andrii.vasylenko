package kickstarter.dao;

import java.util.List;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public class CategoryDaoImpl implements CategoryDao {
	private final static String TABLE_NAME = Category.class.getSimpleName();

	private DaoSupport<Category> daoSupport;

	public CategoryDaoImpl(DaoSupport<Category> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public List<Category> getCategories() throws DataBaseException {
		return daoSupport.find(TABLE_NAME, "", 0);
	}
}
