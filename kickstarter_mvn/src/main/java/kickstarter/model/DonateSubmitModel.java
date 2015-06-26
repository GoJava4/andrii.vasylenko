package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateSubmitModel extends AbstractModel {
	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null
				|| parameters.get("paymentVariant") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = getInt(parameters.get("project"));
		int categoryId = getInt(parameters.get("category"));

		String paymentVariant = getString(parameters.get("paymentVariant"));
		int amount;
		if (paymentVariant.equals("other")) {
			amount = getInt(parameters.get("amount"));
		} else {
			amount = getDao().getPaymentVariant(Integer.parseInt(paymentVariant), id).getAmount();
		}

		if (amount <= 0) {
			throw new IncorrectInputException("can not donate: amount is not correct");
		}

		getDao().donate(id, amount);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("project", getDao().getProject(id, categoryId));
		result.put("amount", amount);

		return result;
	}
}
