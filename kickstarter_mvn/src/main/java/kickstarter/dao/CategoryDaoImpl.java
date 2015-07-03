package kickstarter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public class CategoryDaoImpl implements CategoryDao {
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) throws DataBaseException {
		if (sessionFactory == null) {
			throw new DataBaseException("sessionFactory is null");
		}
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() throws DataBaseException {
		List<?> result = sessionFactory.getCurrentSession().createCriteria(Category.class).list();

		check(result);

		return (List<Category>) result;
	}

	private void check(List<?> result) throws DataBaseException {
		if (result == null || result.isEmpty()) {
			throw new DataBaseException("there is no data in Category table");
		}
	}
}
