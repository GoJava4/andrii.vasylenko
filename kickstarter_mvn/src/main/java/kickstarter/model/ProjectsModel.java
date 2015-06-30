package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class ProjectsModel implements Model {
	private DAO<Project> projectDAO;

	public void setProjectDAO(DAO<Project> projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		Map<String, Object> result = new HashMap<String, Object>();

		int categoryId = Integer.parseInt(parameters.get("category")[0]);
		result.put("projects", projectDAO.getEntities(categoryId));

		return result;
	}
}
