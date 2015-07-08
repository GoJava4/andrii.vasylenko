package kickstarter.dao.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.CategoryDao;
import kickstarter.dao.hibernate.support.DaoSupport;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public class CategoryDaoImpl implements CategoryDao {
	private DaoSupport<Category> daoSupport;

	public void setDaoSupport(DaoSupport<Category> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Transactional
	@Override
	public void persist(Category category) throws DataBaseException {
		daoSupport.persist(category);
	}

	@Transactional(readOnly = true)
	@Override
	@SuppressWarnings("unchecked")
	public List<Category> loadAll() throws DataBaseException {
		List<?> result = daoSupport.getCurrentSession().createCriteria(Category.class).list();

		daoSupport.check(result);

		return (List<Category>) result;
	}

	@Transactional(readOnly = true)
	@Override
	public Category load(int id) throws DataBaseException {
		return daoSupport.load(id, Category.class);
	}
}
