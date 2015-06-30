package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.PaymentVariantDAO;
import kickstarter.dao.ProjectDAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateModel implements Model {
	private ProjectDAO projectDAO;
	private PaymentVariantDAO paymentVariantDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setPaymentVariantDAO(PaymentVariantDAO paymentVariantDAO) {
		this.paymentVariantDAO = paymentVariantDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = Integer.parseInt(parameters.get("project")[0]);
		int categoryId = Integer.parseInt(parameters.get("category")[0]);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("project", projectDAO.getProject(id, categoryId));
		result.put("paymentVariants", paymentVariantDAO.getPaymentVariants(id));

		return result;
	}
}
