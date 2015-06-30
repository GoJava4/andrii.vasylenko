package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;

import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuoteModel implements Model {

	private DAO<Quote> quoteDAO;

	public void setQuoteDAO(DAO<Quote> quoteDAO) {
		this.quoteDAO = quoteDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("quote", quoteDAO.getEntity());

		return result;
	}
}
