package kickstarter.service;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.QuoteDao;
import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuoteService {
	private QuoteDao quoteDao;

	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}

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
}
