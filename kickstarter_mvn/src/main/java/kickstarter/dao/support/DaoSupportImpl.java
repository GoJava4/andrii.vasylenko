package kickstarter.dao.support;

import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class DaoSupportImpl<T> extends HibernateDaoSupport implements DaoSupport<T> {
	@Override
	public void addEntity(T entity) throws IncorrectInputException {
		if (entity == null) {
			throw new IncorrectInputException("entity is null");
		}
		getHibernateTemplate().save(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> find(String query, int maxResults, Object... parameters) throws DataBaseException {
		HibernateTemplate template = getHibernateTemplate();
		template.setMaxResults(maxResults);
		List<?> result = template.find(query, parameters);
		check(query, result);
		return (List<T>) result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> find(DetachedCriteria criteria) throws DataBaseException {
		HibernateTemplate template = getHibernateTemplate();
		template.setMaxResults(0);
		List<?> result = template.findByCriteria(criteria);
		check(criteria.getAlias(), result);
		return (List<T>) result;
	}

	private void check(String tableName, List<?> result) throws DataBaseException {
		if (result.isEmpty()) {
			throw new DataBaseException(String.format("there is no data in table %s", tableName));
		}
	}
}
