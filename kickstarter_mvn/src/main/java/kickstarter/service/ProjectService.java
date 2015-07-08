package kickstarter.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.ProjectDao;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

public class ProjectService {
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

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
}
