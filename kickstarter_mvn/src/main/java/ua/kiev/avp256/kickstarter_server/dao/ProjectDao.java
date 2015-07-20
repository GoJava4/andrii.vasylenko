package ua.kiev.avp256.kickstarter_server.dao;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.entity.Project;

public interface ProjectDao extends GenericDao<Project> {
	/**
	 * return all projects in category where 'id' = 'categoryId' from DB
	 * 
	 * @param categoryId
	 *            - id of category which linked to list of projects
	 * 
	 * @throws DataNotFoundException
	 *             when there are no any project in category
	 */
	List<Project> loadProjectsInCategory(int categoryId);
}
