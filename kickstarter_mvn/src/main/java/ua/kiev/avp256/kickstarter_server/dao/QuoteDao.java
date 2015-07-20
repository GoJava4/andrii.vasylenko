package ua.kiev.avp256.kickstarter_server.dao;

import ua.kiev.avp256.kickstarter_server.entity.Quote;

public interface QuoteDao extends GenericDao<Quote> {
	/**
	 * return random quote from DB
	 * 
	 * @throws DataNotFoundException
	 *             when there are no any quote in DB
	 */
	Quote loadRandom();
}
