package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Project;

public class ProjectDaoImpl implements ProjectDao {
	private DaoSupport daoSupport;

	@Override
	public void persist(Project project) {
		daoSupport.persist(project);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> loadProjectsInCategory(int categoryId) {
		List<?> result = daoSupport.getCurrentSession().createCriteria(Project.class)
				.add(Restrictions.eq("category.id", categoryId)).list();

		daoSupport.check(result);

		return (List<Project>) result;
	}

	@Override
	public Project load(int id) {
		return daoSupport.load(id, Project.class);
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
