package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.entity.Payment;
import kickstarter.entity.PaymentVariant;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateSubmitModel implements Model {
	private DAO<Project> projectDAO;
	private DAO<PaymentVariant> paymentVariantDAO;
	private DAO<Payment> paymentDAO;

	public void setProjectDAO(DAO<Project> projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setPaymentVariantDAO(DAO<PaymentVariant> paymentVariantDAO) {
		this.paymentVariantDAO = paymentVariantDAO;
	}

	public void setPaymentDAO(DAO<Payment> paymentDAO) {
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
			amount = paymentVariantDAO.getEntity(Integer.parseInt(paymentVariant), id).getAmount();
		}

		if (amount <= 0) {
			throw new IncorrectInputException("can not donate: amount is not correct");
		}

		Project project = projectDAO.getEntity(id, categoryId);
		Payment payment = new Payment();
		payment.setProject(project);
		payment.setAmount(amount);
		paymentDAO.addEntity(payment);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("project", project);
		result.put("amount", amount);

		return result;
	}
}
