package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.entity.PaymentVariant;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class DonateModel implements Model {
	private DAO<Project> projectDAO;
	private DAO<PaymentVariant> paymentVariantDAO;

	public void setProjectDAO(DAO<Project> projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setPaymentVariantDAO(DAO<PaymentVariant> paymentVariantDAO) {
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
		result.put("project", projectDAO.getEntity(id, categoryId));
		result.put("paymentVariants", paymentVariantDAO.getEntities(id));

		return result;
	}
}
