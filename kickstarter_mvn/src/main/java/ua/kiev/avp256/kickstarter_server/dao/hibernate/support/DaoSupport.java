package ua.kiev.avp256.kickstarter_server.dao.hibernate.support;

import java.util.List;

import org.hibernate.Session;

import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public interface DaoSupport<ENTITY> {
	Session getCurrentSession();

	void persist(ENTITY entity) throws DataBaseException;

	ENTITY load(int id, Class<ENTITY> clazz) throws DataBaseException;

	void check(List<?> result) throws DataBaseException;
}
