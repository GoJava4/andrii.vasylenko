package kickstarter.dao;

import java.util.List;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

public class ProjectDaoImpl implements ProjectDao {
	private final static String CONDITION_FOR_LIST_OF_ENTITIES = "where id_category = ?";
	private final static String CONDITION_FOR_ONE_ENTITY = "where id = ? and id_category = ?";
	private final static String TABLE_NAME = Project.class.getSimpleName();

	private DaoSupport<Project> daoSupport;

	public ProjectDaoImpl(DaoSupport<Project> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public List<Project> getProjects(int categoryId) throws DataBaseException {
		return daoSupport.find(TABLE_NAME, CONDITION_FOR_LIST_OF_ENTITIES, 0, categoryId);
	}

	@Override
	public Project getProject(int projectId, int categoryId) throws DataBaseException {
		return daoSupport.find(TABLE_NAME, CONDITION_FOR_ONE_ENTITY, 1, projectId, categoryId).get(0);
	}
}
