package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;

public class ProjectService {
	private static final Logger LOG = LogManager.getLogger(ProjectService.class);

	private ProjectDao projectDao;

	@Transactional(readOnly = true)
	public Project loadProject(int projectId) {
		LOG.entry(projectId);
		return LOG.exit(projectDao.load(projectId));
	}

	@Transactional(readOnly = true)
	public List<Project> loadProjectsInCategory(int categoryId) {
		LOG.entry(categoryId);
		return LOG.exit(projectDao.loadProjectsInCategory(categoryId));
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
}
