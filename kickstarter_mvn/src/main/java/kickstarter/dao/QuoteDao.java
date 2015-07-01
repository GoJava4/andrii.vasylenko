package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuoteDao extends AbstractDao<Quote> {
	private final static String CONDITION_FOR_ONE_ENTITY = "order by random()";

	/**
	 * do not need any parameters
	 */
	@Override
	public List<Quote> getEntities(Object... parameters) throws DataBaseException {
		return find("", 0);
	}

	/**
	 * do not need any parameters
	 */
	@Override
	public Quote getEntity(Object... parameters) throws DataBaseException {
		return find(CONDITION_FOR_ONE_ENTITY, 1).get(0);
	}

	@Override
	protected String getTableName() {
		return Quote.class.getSimpleName();
	}
}
