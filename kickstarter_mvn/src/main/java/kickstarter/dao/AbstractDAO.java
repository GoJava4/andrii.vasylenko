package kickstarter.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import kickstarter.exception.DataBaseException;

public abstract class AbstractDAO<T> extends HibernateDaoSupport implements DAO<T> {
	private String tableName;
	private String conditionForOne;
	private String conditionForMany;

	protected AbstractDAO(String tableName, String conditionForOne, String conditionForMany) {
		this.tableName = tableName;
		this.conditionForOne = conditionForOne;
		this.conditionForMany = conditionForMany;
	}

	@Override
	public void addEntity(T entity) throws DataBaseException {
		getHibernateTemplate().save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getEntities(Object... paramerers) throws DataBaseException {
		String query = String.format("from %s %s", tableName, conditionForMany);
		List<?> result = getHibernateTemplate().find(query, paramerers);
		check(result);
		return (List<T>) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntity(Object... paramerers) throws DataBaseException {
		String query = String.format("from %s %s", tableName, conditionForOne);
		HibernateTemplate template = getHibernateTemplate();
		template.setMaxResults(1);
		List<?> result = template.find(query, paramerers);
		check(result);
		return (T) result.get(0);
	}

	private void check(List<?> result) throws DataBaseException {
		if (result.isEmpty()) {
			throw new DataBaseException(String.format("there is no data in table %s", tableName));
		}
	}
}
