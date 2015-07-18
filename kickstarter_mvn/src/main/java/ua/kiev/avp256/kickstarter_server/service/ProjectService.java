package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class ProjectService {
	private ProjectDao projectDao;

	@Transactional(readOnly = true)
	public Project loadProject(int projectId) {
		try {
			return projectDao.load(projectId);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Transactional(readOnly = true)
	public List<Project> loadProjectsInCategory(int categoryId) {
		try {
			return projectDao.loadProjectsInCategory(categoryId);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
}
