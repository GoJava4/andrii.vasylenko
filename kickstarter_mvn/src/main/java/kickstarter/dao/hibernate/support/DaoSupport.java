package kickstarter.dao.hibernate.support;

import java.util.List;

import kickstarter.exception.DataBaseException;

import org.hibernate.Session;

public interface DaoSupport<ENTITY> {
	Session getCurrentSession();

	void persist(ENTITY entity) throws DataBaseException;

	ENTITY load(int id, Class<ENTITY> clazz) throws DataBaseException;

	void check(List<?> result) throws DataBaseException;
}
