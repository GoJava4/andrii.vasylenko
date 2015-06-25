package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateSubmitModel implements Model {
	private DAO dao;

	@Override
	public void setDao(DAO dao) throws IncorrectInputException {
		if (dao == null) {
			throw new IncorrectInputException("can not init: dao is null");
		}
		this.dao = dao;
	}

	@Override
	public Map<String, Object> getData(Map<String, Object> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null
				|| parameters.get("paymentVariant") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = (int) parameters.get("project");
		int categoryId = (int) parameters.get("category");

		String paymentVariant = (String) parameters.get("paymentVariant");
		int amount;
		if (paymentVariant.equals("other")) {
			amount = Integer.parseInt((String) parameters.get("amount"));
		} else {
			amount = dao.getPaymentVariant(Integer.parseInt(paymentVariant), id).getAmount();
		}

		if (amount <= 0) {
			throw new IncorrectInputException("can not donate: amount is not correct");
		}

		dao.donate(id, amount);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("project", dao.getProject(id, categoryId));
		result.put("amount", amount);

		return result;
	}
}
