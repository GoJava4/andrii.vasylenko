package ua.kiev.avp256.kickstarter_server.dao.hibernate.support;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;

public class HibernateDaoSupport implements DaoSupport {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <ENTITY> void persist(ENTITY entity) {
		if (entity == null) {
			throw new DataNotFoundException("entity is null");
		}
		getCurrentSession().persist(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <ENTITY> ENTITY load(int id, Class<ENTITY> clazz) {
		List<?> result = sessionFactory.getCurrentSession().createCriteria(clazz).add(Restrictions.idEq(id)).list();

		check(result);

		return (ENTITY) result.get(0);
	}

	@Override
	public void check(List<?> result) {
		if (result == null || result.isEmpty()) {
			throw new DataNotFoundException("there are no data in table");
		}
	}
}
