package kickstarter.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

public class ProjectDaoImpl implements ProjectDao {
	private DaoSupport<Project> daoSupport;

	public ProjectDaoImpl(DaoSupport<Project> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public List<Project> getProjects(int categoryId) throws DataBaseException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		criteria.add(Restrictions.eq("category.id", categoryId));
		return daoSupport.find(criteria);
	}

	@Override
	public Project getProject(int projectId, int categoryId) throws DataBaseException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		criteria.add(Restrictions.idEq(projectId));
		criteria.add(Restrictions.eq("category.id", categoryId));
		return daoSupport.find(criteria).get(0);
	}
}
