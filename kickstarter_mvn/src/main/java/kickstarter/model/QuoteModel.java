package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.QuoteDAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuoteModel extends AbstractModel {
	
	private QuoteDAO quoteDAO;

	public void setQuoteDAO(QuoteDAO quoteDAO) {
		this.quoteDAO = quoteDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("quote", quoteDAO.getRandomQuote());

		return result;
	}
}
