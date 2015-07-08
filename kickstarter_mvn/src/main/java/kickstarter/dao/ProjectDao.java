package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

public interface ProjectDao extends GenericDao<Project>  {
	/**
	 * return all projects from DB
	 * 
	 * @param categoryId
	 *            - id of category which linked to list of projects
	 */
	List<Project> loadProjectsInCategory(int categoryId) throws DataBaseException;
}
