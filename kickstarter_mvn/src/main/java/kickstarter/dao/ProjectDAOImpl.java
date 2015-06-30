package kickstarter.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import kickstarter.entity.Project;

public class ProjectDAOImpl extends HibernateDaoSupport implements ProjectDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects(int categoryId) {
		return (List<Project>) getHibernateTemplate().find("from Project where id_category = ?", categoryId);
	}

	@Override
	public Project getProject(int id, int categoryId) {
		List<?> find = getHibernateTemplate().find("from Project where id = ? and id_category = ?", id, categoryId);
		return (Project) find.get(0);
	}

}
