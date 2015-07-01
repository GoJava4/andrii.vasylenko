package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.Dao;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuoteModel implements Model {
	private Dao<Quote> quoteDAO;

	public void setQuoteDAO(Dao<Quote> quoteDAO) {
		this.quoteDAO = quoteDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("quote", quoteDAO.getEntity());

		return result;
	}
}
