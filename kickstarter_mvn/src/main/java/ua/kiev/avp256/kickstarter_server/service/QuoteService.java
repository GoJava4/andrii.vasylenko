package ua.kiev.avp256.kickstarter_server.service;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.QuoteDao;
import ua.kiev.avp256.kickstarter_server.entity.Quote;

public class QuoteService {
	private QuoteDao quoteDao;

	@Transactional(readOnly = true)
	public Quote loadRandomQuote() {
		return quoteDao.loadRandom();
	}

	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}
}
