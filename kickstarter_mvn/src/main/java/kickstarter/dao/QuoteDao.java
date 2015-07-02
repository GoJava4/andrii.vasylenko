package kickstarter.dao;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public interface QuoteDao {
	/**
	 * return random quote from DB
	 */
	Quote getRandomQuote() throws DataBaseException;
}
