package kickstarter.dao.sub;

import java.sql.SQLException;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public interface QuotesDAO {
	/**
	 * add new Quote to DB
	 */
	void addQuote(String quote) throws DataBaseException, SQLException;

	/**
	 * return random Quote from DB
	 */
	Quote getRandomQuote() throws DataBaseException, SQLException;

	/**
	 * create table Quotes in DB
	 */
	void createTableQuotes() throws DataBaseException, SQLException;
}
