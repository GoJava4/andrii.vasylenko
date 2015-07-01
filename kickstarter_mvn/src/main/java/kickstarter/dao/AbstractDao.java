package kickstarter.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public abstract class AbstractDao<T> extends HibernateDaoSupport implements Dao<T> {
	@Override
	public void addEntity(T entity) throws IncorrectInputException {
		if (entity == null) {
			throw new IncorrectInputException("entity is null");
		}
		getHibernateTemplate().save(entity);
	}

	protected abstract String getTableName();

	@SuppressWarnings("unchecked")
	protected List<T> find(String condition, int maxResults, Object... parameters) throws DataBaseException {
		String query = String.format("from %s %s", getTableName(), condition);
		HibernateTemplate template = getHibernateTemplate();
		template.setMaxResults(maxResults);
		List<?> result = template.find(query, parameters);
		check(result);
		return (List<T>) result;
	}

	protected int getIntParameter(int index, Object... parameters) throws IncorrectInputException {
		if (parameters == null || parameters.length <= index) {
			throw new IncorrectInputException("parameters is empty");
		}

		try {
			return (int) parameters[index];
		} catch (ClassCastException e) {
			throw new IncorrectInputException("parameter is not integer", e);
		}
	}

	private void check(List<?> result) throws DataBaseException {
		if (result.isEmpty()) {
			throw new DataBaseException(String.format("there is no data in table %s", getTableName()));
		}
	}
}
