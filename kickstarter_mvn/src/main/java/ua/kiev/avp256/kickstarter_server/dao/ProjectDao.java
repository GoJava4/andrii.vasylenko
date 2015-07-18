package ua.kiev.avp256.kickstarter_server.dao;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public interface ProjectDao extends GenericDao<Project>  {
	/**
	 * return all projects from DB
	 * 
	 * @param categoryId
	 *            - id of category which linked to list of projects
	 */
	List<Project> loadProjectsInCategory(int categoryId) throws DataBaseException;
}
