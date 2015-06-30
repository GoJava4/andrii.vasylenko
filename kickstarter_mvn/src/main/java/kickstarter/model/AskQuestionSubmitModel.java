package kickstarter.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.entity.Project;
import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class AskQuestionSubmitModel implements Model {
	private DAO<Project> projectDAO;
	private DAO<Question> questionDAO;

	public void setProjectDAO(DAO<Project> projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setQuestionDAO(DAO<Question> questionDAO) {
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

		Project project = projectDAO.getEntity(id, categoryId);
		Question entity = new Question();
		entity.setProject(project);
		entity.setQuestion(question);
		questionDAO.addEntity(entity);

		result.put("project", project);
		result.put("question", question);

		return result;
	}

}
