package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.Dao;
import kickstarter.entity.PaymentVariant;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateModel implements Model {
	private Dao<Project> projectDAO;
	private Dao<PaymentVariant> paymentVariantDAO;

	public void setProjectDAO(Dao<Project> projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setPaymentVariantDAO(Dao<PaymentVariant> paymentVariantDAO) {
		this.paymentVariantDAO = paymentVariantDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {
		checkInput(parameters);

		Map<String, Object> result = new HashMap<String, Object>();

		int projectId = getProjectId(parameters);
		int categoryId = getCategoryId(parameters);
		result.put("project", projectDAO.getEntity(projectId, categoryId));
		result.put("paymentVariants", paymentVariantDAO.getEntities(projectId));

		return result;
	}

	private int getCategoryId(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("category")[0]);
	}

	private int getProjectId(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("project")[0]);
	}

	private void checkInput(Map<String, String[]> parameters) throws IncorrectInputException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}
	}
}
