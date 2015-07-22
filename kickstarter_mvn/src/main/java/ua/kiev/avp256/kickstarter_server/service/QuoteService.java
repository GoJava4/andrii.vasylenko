package ua.kiev.avp256.kickstarter_server.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.QuoteDao;
import ua.kiev.avp256.kickstarter_server.entity.Quote;

public class QuoteService {
	private static final Logger LOG = LogManager.getLogger(QuoteService.class);

	private QuoteDao quoteDao;

	@Transactional(readOnly = true)
	public Quote loadRandomQuote() {
		LOG.entry();
		return LOG.exit(quoteDao.loadRandom());
	}

	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}
}
