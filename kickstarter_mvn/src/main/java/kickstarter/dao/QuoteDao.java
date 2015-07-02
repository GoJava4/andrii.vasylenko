package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuoteDao extends AbstractDao<Quote> {
	private final static String RANDOM_ORDER = "order by random()";

	/**
	 * do not need any parameters
	 */
	@Override
	public List<Quote> getEntities(Object... parameters) throws DataBaseException {
		return find(RANDOM_ORDER, 0);
	}

	/**
	 * do not need any parameters
	 */
	@Override
	public Quote getEntity(Object... parameters) throws DataBaseException {
		return find(RANDOM_ORDER, 1).get(0);
	}

	@Override
	protected String getTableName() {
		return Quote.class.getSimpleName();
	}
}
