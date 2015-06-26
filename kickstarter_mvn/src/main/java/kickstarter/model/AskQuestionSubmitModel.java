package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class AskQuestionSubmitModel extends AbstractModel {
	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null
				|| parameters.get("question") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = getInt(parameters.get("project"));
		int categoryId = getInt(parameters.get("category"));
		String question = getString(parameters.get("question"));

		if (question.isEmpty()) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		getDao().addQuestion(id, question);

		result.put("project", getDao().getProject(id, categoryId));
		result.put("question", question);

		return result;
	}

}
