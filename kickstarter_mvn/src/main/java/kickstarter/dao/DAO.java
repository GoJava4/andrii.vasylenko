package kickstarter.dao;

import java.util.List;

import kickstarter.exception.DataBaseException;

public interface DAO<T> {
	void addEntity(T entity) throws DataBaseException;

	List<T> getEntities(Object... paramerers) throws DataBaseException;

	T getEntity(Object... paramerers) throws DataBaseException;
}
