package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.Dao;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class AskQuestionModel implements Model {
	private Dao<Project> projectDao;

	public void setProjectDao(Dao<Project> projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {
		checkInput(parameters);

		Map<String, Object> result = new HashMap<String, Object>();

		int projectId = getProjectId(parameters);
		int categoryId = getCategoryId(parameters);
		result.put("project", projectDao.getEntity(projectId, categoryId));

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
