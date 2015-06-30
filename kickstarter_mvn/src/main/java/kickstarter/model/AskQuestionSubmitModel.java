package kickstarter.model;

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
			DataBaseException {
		checkInput(parameters);

		int projectId = getProjectId(parameters);
		int categoryId = getCategoryId(parameters);
		String question = getQuestion(parameters);
		Project project = projectDAO.getEntity(projectId, categoryId);

		addQuestion(question, project);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("project", project);
		result.put("question", question);

		return result;
	}

	private void addQuestion(String question, Project project) throws IncorrectInputException, DataBaseException {
		if (question.isEmpty()) {
			throw new IncorrectInputException("can not init: parameters is null");
		}

		Question entity = new Question();
		entity.setProject(project);
		entity.setQuestion(question);
		questionDAO.addEntity(entity);
	}

	private String getQuestion(Map<String, String[]> parameters) {
		return parameters.get("question")[0];
	}

	private int getCategoryId(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("category")[0]);
	}

	private int getProjectId(Map<String, String[]> parameters) {
		return Integer.parseInt(parameters.get("project")[0]);
	}

	private void checkInput(Map<String, String[]> parameters) throws IncorrectInputException {
		if (parameters == null || parameters.get("project") == null || parameters.get("category") == null
				|| parameters.get("question") == null) {
			throw new IncorrectInputException("can not init: parameters is null");
		}
	}

}
