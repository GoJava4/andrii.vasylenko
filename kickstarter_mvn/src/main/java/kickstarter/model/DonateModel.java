package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateModel extends AbstractModel {
	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = getInt(parameters.get("project"));
		int categoryId = getInt(parameters.get("category"));

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("project", getDao().getProject(id, categoryId));
		result.put("paymentVariants", getDao().getPaymentVariants(id));

		return result;
	}
}
