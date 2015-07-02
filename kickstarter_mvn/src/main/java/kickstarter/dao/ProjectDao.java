package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

public interface ProjectDao {
	/**
	 * return all projects from DB
	 * 
	 * @param categoryId
	 *            - id of category which linked to list of projects
	 */
	List<Project> getProjects(int categoryId) throws DataBaseException;

	/**
	 * return project from DB
	 * 
	 * @param projectId
	 *            - id of project
	 * @param categoryId
	 *            - id of category which linked to list of projects
	 */
	Project getProject(int projectId, int categoryId) throws DataBaseException;
}
