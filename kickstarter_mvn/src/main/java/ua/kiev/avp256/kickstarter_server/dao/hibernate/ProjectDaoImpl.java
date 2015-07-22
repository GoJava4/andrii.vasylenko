package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Project;

public class ProjectDaoImpl implements ProjectDao {
	private static final Logger LOG = LogManager.getLogger(ProjectDaoImpl.class);

	private DaoSupport daoSupport;

	@Override
	public void persist(Project project) {
		LOG.entry(project);
		daoSupport.persist(project);
		LOG.exit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> loadProjectsInCategory(int categoryId) {
		LOG.entry(categoryId);

		List<?> result = daoSupport.getCurrentSession().createCriteria(Project.class)
				.add(Restrictions.eq("category.id", categoryId)).list();

		daoSupport.check(result);

		return LOG.exit((List<Project>) result);
	}

	@Override
	public Project load(int id) {
		LOG.entry(id);
		return LOG.exit(daoSupport.load(id, Project.class));
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
