package ua.kiev.avp256.kickstarter_server.dao.hibernate.support;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;

public class HibernateDaoSupport implements DaoSupport {
	private static final Logger LOG = LogManager.getLogger(HibernateDaoSupport.class);

	private SessionFactory sessionFactory;

	@Override
	public Session getCurrentSession() {
		LOG.entry();
		return LOG.exit(sessionFactory.getCurrentSession());
	}

	@Override
	public void persist(Object entity) {
		LOG.entry(entity);
		if (entity == null) {
			throw new DataNotFoundException("entity is null");
		}
		getCurrentSession().persist(entity);
		LOG.exit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <ENTITY> ENTITY load(int id, Class<ENTITY> clazz) {
		LOG.entry(id, clazz);

		List<?> result = getCurrentSession().createCriteria(clazz).add(Restrictions.idEq(id)).list();

		check(result);

		return LOG.exit((ENTITY) result.get(0));
	}

	@Override
	public void check(List<?> result) {
		LOG.entry(result);
		if (result == null || result.isEmpty()) {
			throw new DataNotFoundException("there are no data in table");
		}
		LOG.exit("result - OK");
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
