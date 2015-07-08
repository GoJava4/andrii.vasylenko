package kickstarter.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import kickstarter.dao.ProjectDao;
import kickstarter.dao.hibernate.support.DaoSupport;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

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
