package ua.kiev.avp256.kickstarter_server.dao.hibernate.support;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class HibernateDaoSupport<ENTITY> implements DaoSupport<ENTITY> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void persist(ENTITY entity) throws DataBaseException {
		if (entity == null) {
			throw new DataBaseException("entity is null");
		}
		getCurrentSession().persist(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public ENTITY load(int id, Class<ENTITY> clazz) throws DataBaseException {
		List<?> result = sessionFactory.getCurrentSession().createCriteria(clazz).add(Restrictions.idEq(id)).list();

		check(result);

		return (ENTITY) result.get(0);
	}

	@Override
	public void check(List<?> result) throws DataBaseException {
		if (result == null || result.isEmpty()) {
			throw new DataBaseException("there is no data in table");
		}
	}
}
