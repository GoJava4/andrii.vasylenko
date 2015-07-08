package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.ProjectDao;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class ProjectsModel implements Model {
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {
		checkInput(parameters);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("projects", projectDao.loadProjectsInCategory(getCategoryId(parameters)));

		return result;
	}

	private int getCategoryId(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("category")[0]);
	}

	private void checkInput(Map<String, String[]> parameters) throws IncorrectInputException {
		if (parameters == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}
	}
}
