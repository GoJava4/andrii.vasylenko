package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class ProjectDao extends AbstractDao<Project> {
	private final static String CONDITION_FOR_LIST_OF_ENTITIES = "where id_category = ?";
	private final static String CONDITION_FOR_ONE_ENTITY = "where id = ? and id_category = ?";

	/**
	 * expect one parameter - id of category
	 */
	@Override
	public List<Project> getEntities(Object... parameters) throws DataBaseException, IncorrectInputException {
		int categoryId = getIntParameter(0, parameters);
		return find(CONDITION_FOR_LIST_OF_ENTITIES, 0, categoryId);
	}

	/**
	 * expect two parameters: 0 - id of project, 1 - id of category
	 */
	@Override
	public Project getEntity(Object... parameters) throws DataBaseException, IncorrectInputException {
		int projectId = getIntParameter(0, parameters);
		int categoryId = getIntParameter(1, parameters);
		return find(CONDITION_FOR_ONE_ENTITY, 1, projectId, categoryId).get(0);
	}

	@Override
	protected String getTableName() {
		return Project.class.getSimpleName();
	}
}
