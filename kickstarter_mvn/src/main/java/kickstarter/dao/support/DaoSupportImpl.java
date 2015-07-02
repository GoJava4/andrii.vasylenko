package kickstarter.dao.support;

import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class DaoSupportImpl<T> extends HibernateDaoSupport implements DaoSupport<T> {
	public void addEntity(T entity) throws IncorrectInputException {
		if (entity == null) {
			throw new IncorrectInputException("entity is null");
		}
		getHibernateTemplate().save(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String tableName, String condition, int maxResults, Object... parameters)
			throws DataBaseException {
		String query = String.format("from %s %s", tableName, condition);
		HibernateTemplate template = getHibernateTemplate();
		template.setMaxResults(maxResults);
		List<?> result = template.find(query, parameters);
		check(tableName, result);
		return (List<T>) result;
	}

	private void check(String tableName, List<?> result) throws DataBaseException {
		if (result.isEmpty()) {
			throw new DataBaseException(String.format("there is no data in table %s", tableName));
		}
	}
}
