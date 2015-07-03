package kickstarter.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public class CategoryDaoImpl implements CategoryDao {
	private DaoSupport<Category> daoSupport;

	public CategoryDaoImpl(DaoSupport<Category> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public List<Category> getCategories() throws DataBaseException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
		return daoSupport.find(criteria);
	}
}
