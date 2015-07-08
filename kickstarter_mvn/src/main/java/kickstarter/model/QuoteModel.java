package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.QuoteDao;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuoteModel implements Model {
	private QuoteDao quoteDao;

	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("quote", quoteDao.loadRandom());

		return result;
	}
}
