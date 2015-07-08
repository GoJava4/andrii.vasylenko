package kickstarter.dao;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public interface QuoteDao extends GenericDao<Quote> {
	/**
	 * return random quote from DB
	 */
	Quote loadRandom() throws DataBaseException;
}
