package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuestionDao extends AbstractDao<Question> {
	private final static String CONDITION_FOR_LIST_OF_ENTITIES = "where id_project = ?";
	private final static String CONDITION_FOR_ONE_ENTITY = "where id = ? and id_project = ?";

	/**
	 * expect one parameter - id of project
	 */
	@Override
	public List<Question> getEntities(Object... parameters) throws DataBaseException, IncorrectInputException {
		int projectId = getIntParameter(0, parameters);
		return find(CONDITION_FOR_LIST_OF_ENTITIES, 0, projectId);
	}

	/**
	 * expect two parameters: 0 - id of question, 1 - id of project
	 */
	@Override
	public Question getEntity(Object... parameters) throws DataBaseException, IncorrectInputException {
		int questionId = getIntParameter(0, parameters);
		int projectId = getIntParameter(1, parameters);
		return find(CONDITION_FOR_ONE_ENTITY, 1, questionId, projectId).get(0);
	}

	@Override
	protected String getTableName() {
		return Question.class.getSimpleName();
	}
}
