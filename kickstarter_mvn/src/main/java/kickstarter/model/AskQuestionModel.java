package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.ProjectDAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class AskQuestionModel implements Model {
	private ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = Integer.parseInt(parameters.get("project")[0]);
		int categoryId = Integer.parseInt(parameters.get("category")[0]);
		result.put("project", projectDAO.getProject(id, categoryId));

		return result;
	}

}
