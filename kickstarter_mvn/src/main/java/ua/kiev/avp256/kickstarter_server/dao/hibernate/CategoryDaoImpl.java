package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.dao.CategoryDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Category;

public class CategoryDaoImpl implements CategoryDao {
	private DaoSupport daoSupport;

	@Override
	public void persist(Category category) {
		daoSupport.persist(category);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> loadAll() {
		List<?> result = daoSupport.getCurrentSession().createCriteria(Category.class).list();

		daoSupport.check(result);

		return (List<Category>) result;
	}

	@Override
	public Category load(int id) {
		return daoSupport.load(id, Category.class);
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
