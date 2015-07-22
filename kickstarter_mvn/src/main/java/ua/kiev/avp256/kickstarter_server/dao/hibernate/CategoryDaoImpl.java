package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.kiev.avp256.kickstarter_server.dao.CategoryDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Category;

public class CategoryDaoImpl implements CategoryDao {
	private static final Logger LOG = LogManager.getLogger(CategoryDaoImpl.class);

	private DaoSupport daoSupport;

	@Override
	public void persist(Category category) {
		LOG.entry(category);
		daoSupport.persist(category);
		LOG.exit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> loadAll() {
		LOG.entry();
		List<?> result = daoSupport.getCurrentSession().createCriteria(Category.class).list();

		daoSupport.check(result);

		return LOG.exit((List<Category>) result);
	}

	@Override
	public Category load(int id) {
		LOG.entry(id);
		return LOG.exit(daoSupport.load(id, Category.class));
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
