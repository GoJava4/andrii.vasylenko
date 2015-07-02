package kickstarter.dao;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuoteDaoImpl implements QuoteDao {
	private final static String RANDOM_ORDER = "order by random()";
	private final static String TABLE_NAME = Quote.class.getSimpleName();

	private DaoSupport<Quote> daoSupport;

	public QuoteDaoImpl(DaoSupport<Quote> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public Quote getRandomQuote() throws DataBaseException {
		return daoSupport.find(TABLE_NAME, RANDOM_ORDER, 1).get(0);
	}
}
