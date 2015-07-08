package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.ProjectDao;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class ProjectModel implements Model {
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {
		checkInput(parameters);

		Map<String, Object> result = new HashMap<String, Object>();

		int projectId = getProjectId(parameters);
		result.put("project", projectDao.load(projectId));

		return result;
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
