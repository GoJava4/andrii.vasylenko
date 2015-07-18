package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class ProjectDaoImpl implements ProjectDao {
	private DaoSupport<Project> daoSupport;

	public void setDaoSupport(DaoSupport<Project> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void persist(Project project) throws DataBaseException {
		daoSupport.persist(project);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> loadProjectsInCategory(int categoryId) throws DataBaseException {
		List<?> result = daoSupport.getCurrentSession().createCriteria(Project.class)
				.add(Restrictions.eq("category.id", categoryId)).list();

		daoSupport.check(result);

		return (List<Project>) result;
	}

	@Override
	public Project load(int id) throws DataBaseException {
		return daoSupport.load(id, Project.class);
	}
}
