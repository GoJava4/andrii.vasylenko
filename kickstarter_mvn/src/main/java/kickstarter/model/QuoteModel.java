package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuoteModel extends AbstractModel {
	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null) {
			throw new IncorrectInputException("can not getData: parameters is null");
		}

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("quote", getDao().getRandomQuote());

		return result;
	}
}
