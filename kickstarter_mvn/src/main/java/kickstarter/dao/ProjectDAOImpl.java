package kickstarter.dao;

import kickstarter.entity.Project;

public class ProjectDAOImpl extends AbstractDAO<Project> {
	protected ProjectDAOImpl() {
		super("Project", "where id = ? and id_category = ?", "where id_category = ?");
	}
}
