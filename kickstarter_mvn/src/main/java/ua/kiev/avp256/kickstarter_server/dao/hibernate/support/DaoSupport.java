package ua.kiev.avp256.kickstarter_server.dao.hibernate.support;

import java.util.List;

import org.hibernate.Session;

public interface DaoSupport {
	Session getCurrentSession();

	void persist(Object entity);

	<ENTITY> ENTITY load(int id, Class<ENTITY> clazz);

	void check(List<?> result);
}
