package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class AskQuestionModel implements Model {
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
		Map<String, Object> result = new HashMap<String, Object>();
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = (int) parameters.get("project");
		int categoryId = (int) parameters.get("category");
		result.put("project", dao.getProject(id, categoryId));

		return result;
	}
}
