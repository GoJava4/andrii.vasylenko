package ua.kiev.avp256.kickstarter_server.dao;

import ua.kiev.avp256.kickstarter_server.entity.Quote;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public interface QuoteDao extends GenericDao<Quote> {
	/**
	 * return random quote from DB
	 */
	Quote loadRandom() throws DataBaseException;
}
