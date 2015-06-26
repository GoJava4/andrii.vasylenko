package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class ProjectsModel extends AbstractModel {
	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		if (parameters == null || parameters.get("category") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		Map<String, Object> result = new HashMap<String, Object>();

		int categoryId = getInt(parameters.get("category"));
		result.put("projects", getDao().getProjects(categoryId));

		return result;
	}
}
