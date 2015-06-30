package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Project;

public interface ProjectDAO {
	List<Project> getProjects(int categoryId);

	Project getProject(int id, int categoryId);
}
