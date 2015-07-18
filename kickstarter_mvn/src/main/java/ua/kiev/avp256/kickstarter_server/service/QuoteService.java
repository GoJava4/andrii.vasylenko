package ua.kiev.avp256.kickstarter_server.service;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.QuoteDao;
import ua.kiev.avp256.kickstarter_server.entity.Quote;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class QuoteService {
	private QuoteDao quoteDao;

	@Transactional(readOnly = true)
	public Quote loadRandomQuote() {
		try {
			return quoteDao.loadRandom();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}
}
