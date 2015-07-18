package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.dao.CategoryDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class CategoryDaoImpl implements CategoryDao {
	private DaoSupport<Category> daoSupport;

	public void setDaoSupport(DaoSupport<Category> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void persist(Category category) throws DataBaseException {
		daoSupport.persist(category);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> loadAll() throws DataBaseException {
		List<?> result = daoSupport.getCurrentSession().createCriteria(Category.class).list();

		daoSupport.check(result);

		return (List<Category>) result;
	}

	@Override
	public Category load(int id) throws DataBaseException {
		return daoSupport.load(id, Category.class);
	}
}
