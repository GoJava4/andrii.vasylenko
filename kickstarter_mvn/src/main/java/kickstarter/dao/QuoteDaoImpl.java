package kickstarter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuoteDaoImpl implements QuoteDao {
	private final static String QUERY_FOR_GET_RANDOM_ENTITY = String.format("from %s order by random()",
			Quote.class.getSimpleName());

	private SessionFactory sessionFactory;

	public QuoteDaoImpl(SessionFactory sessionFactory) throws DataBaseException {
		if (sessionFactory == null) {
			throw new DataBaseException("sessionFactory is null");
		}
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@Override
	public Quote getRandomQuote() throws DataBaseException {
		List<?> result = sessionFactory.getCurrentSession().createQuery(QUERY_FOR_GET_RANDOM_ENTITY).list();

		check(result);

		return (Quote) result.get(0);
	}

	private void check(List<?> result) throws DataBaseException {
		if (result == null || result.isEmpty()) {
			throw new DataBaseException("there is no data in Quote table");
		}
	}
}
