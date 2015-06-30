package kickstarter.model;

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
			DataBaseException {
		checkInput(parameters);

		int projectId = getProjectId(parameters);
		int categoryId = getCategoryId(parameters);

		int amount = getAmount(parameters);
		Project project = projectDAO.getEntity(projectId, categoryId);

		donate(amount, project);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("project", project);
		result.put("amount", amount);

		return result;
	}

	private void donate(int amount, Project project) throws DataBaseException {
		Payment payment = new Payment();
		payment.setProject(project);
		payment.setAmount(amount);
		paymentDAO.addEntity(payment);
	}

	private int getAmount(Map<String, String[]> parameters) throws DataBaseException, IncorrectInputException {

		String paymentVariant = getPaymentVariant(parameters);

		int amount;
		if ("other".equals(paymentVariant)) {
			amount = getAmountFromParameters(parameters);
		} else {
			amount = getAmountFromPaymentVariant(paymentVariant, getProjectId(parameters));
		}

		if (amount <= 0) {
			throw new IncorrectInputException("can not donate: amount is not correct");
		}
		return amount;
	}

	private int getAmountFromPaymentVariant(String paymentVariant, int projectId) throws DataBaseException {
		int paymentVariantId = Integer.parseInt(paymentVariant);
		PaymentVariant entity = paymentVariantDAO.getEntity(paymentVariantId, projectId);
		return entity.getAmount();
	}

	private int getAmountFromParameters(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("amount")[0]);
	}

	private String getPaymentVariant(Map<String, String[]> parameters) {
		return parameters.get("paymentVariant")[0];
	}

	private int getCategoryId(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("category")[0]);
	}

	private int getProjectId(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("project")[0]);
	}

	private void checkInput(Map<String, String[]> parameters) throws IncorrectInputException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null
				|| parameters.get("paymentVariant") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}
	}
}
