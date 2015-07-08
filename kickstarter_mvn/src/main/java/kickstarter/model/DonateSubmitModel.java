package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.PaymentDao;
import kickstarter.dao.PaymentVariantDao;
import kickstarter.dao.ProjectDao;
import kickstarter.entity.Payment;
import kickstarter.entity.PaymentVariant;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateSubmitModel implements Model {
	private ProjectDao projectDao;
	private PaymentVariantDao paymentVariantDao;
	private PaymentDao paymentDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setPaymentVariantDao(PaymentVariantDao paymentVariantDao) {
		this.paymentVariantDao = paymentVariantDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {
		checkInput(parameters);

		int projectId = getProjectId(parameters);

		int amount = getAmount(parameters);
		Project project = projectDao.load(projectId);

		donate(amount, project);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("project", project);
		result.put("amount", amount);

		return result;
	}

	private void donate(int amount, Project project) throws DataBaseException, IncorrectInputException {
		Payment payment = new Payment();
		payment.setProject(project);
		payment.setAmount(amount);
		paymentDao.persist(payment);
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

	private int getAmountFromPaymentVariant(String paymentVariant, int projectId) throws DataBaseException,
			IncorrectInputException {
		int paymentVariantId = Integer.parseInt(paymentVariant);
		PaymentVariant entity = paymentVariantDao.load(paymentVariantId);
		return entity.getAmount();
	}

	private int getAmountFromParameters(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("amount")[0]);
	}

	private String getPaymentVariant(Map<String, String[]> parameters) {
		return parameters.get("paymentVariant")[0];
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
