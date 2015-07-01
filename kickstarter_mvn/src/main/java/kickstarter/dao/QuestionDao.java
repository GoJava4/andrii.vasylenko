package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuestionDao extends AbstractDao<Question> {
	private final static String CONDITION_FOR_LIST_OF_ENTITIES = "where id_project = ?";

	/**
	 * expect one parameter - id of project
	 */
	@Override
	public List<Question> getEntities(Object... parameters) throws DataBaseException, IncorrectInputException {
		int projectId = getIntParameter(0, parameters);
		return find(CONDITION_FOR_LIST_OF_ENTITIES, 0, projectId);
	}

	/**
	 * do not need any parameters
	 */
	@Override
	public Question getEntity(Object... parameters) throws DataBaseException, IncorrectInputException {
		return find("", 1).get(0);
	}

	@Override
	protected String getTableName() {
		return Question.class.getSimpleName();
	}
}
