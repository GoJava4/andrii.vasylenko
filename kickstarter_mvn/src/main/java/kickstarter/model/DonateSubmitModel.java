package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.PaymentDAO;
import kickstarter.dao.PaymentVariantDAO;
import kickstarter.dao.ProjectDAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateSubmitModel implements Model {
	private ProjectDAO projectDAO;
	private PaymentVariantDAO paymentVariantDAO;
	private PaymentDAO paymentDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setPaymentVariantDAO(PaymentVariantDAO paymentVariantDAO) {
		this.paymentVariantDAO = paymentVariantDAO;
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null
				|| parameters.get("paymentVariant") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = Integer.parseInt(parameters.get("project")[0]);
		int categoryId = Integer.parseInt(parameters.get("category")[0]);

		String paymentVariant = parameters.get("paymentVariant")[0];
		int amount;
		if (paymentVariant.equals("other")) {
			amount = Integer.parseInt(parameters.get("amount")[0]);
		} else {
			amount = paymentVariantDAO.getPaymentVariant(Integer.parseInt(paymentVariant), id).getAmount();
		}

		if (amount <= 0) {
			throw new IncorrectInputException("can not donate: amount is not correct");
		}

		paymentDAO.donate(id, amount);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("project", projectDAO.getProject(id, categoryId));
		result.put("amount", amount);

		return result;
	}
}
