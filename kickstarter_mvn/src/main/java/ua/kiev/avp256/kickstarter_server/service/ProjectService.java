package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;

public class ProjectService {
	private ProjectDao projectDao;

	@Transactional(readOnly = true)
	public Project loadProject(int projectId) {
		return projectDao.load(projectId);
	}

	@Transactional(readOnly = true)
	public List<Project> loadProjectsInCategory(int categoryId) {
		return projectDao.loadProjectsInCategory(categoryId);
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
}
