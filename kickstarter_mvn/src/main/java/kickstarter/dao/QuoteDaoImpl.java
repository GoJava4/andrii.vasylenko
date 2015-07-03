package kickstarter.dao;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuoteDaoImpl implements QuoteDao {
	private final static String QUERY_FOR_GET_RANDOM_ENTITY = "from %s order by random()";

	private DaoSupport<Quote> daoSupport;

	public QuoteDaoImpl(DaoSupport<Quote> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public Quote getRandomQuote() throws DataBaseException {
		String query = String.format(QUERY_FOR_GET_RANDOM_ENTITY, Quote.class.getSimpleName());
		return daoSupport.find(query, 1).get(0);
	}
}
