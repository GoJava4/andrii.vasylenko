package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.ProjectDAO;
import kickstarter.dao.QuestionDAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class AskQuestionSubmitModel implements Model {
	private ProjectDAO projectDAO;
	private QuestionDAO questionDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException, SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null
				|| parameters.get("question") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		int id = Integer.parseInt(parameters.get("project")[0]);
		int categoryId = Integer.parseInt(parameters.get("category")[0]);
		String question = parameters.get("question")[0];

		if (question.isEmpty()) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		questionDAO.addQuestion(id, question);

		result.put("project", projectDAO.getProject(id, categoryId));
		result.put("question", question);

		return result;
	}

}
