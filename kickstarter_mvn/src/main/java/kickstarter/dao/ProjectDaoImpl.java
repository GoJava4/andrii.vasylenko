package kickstarter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

public class ProjectDaoImpl implements ProjectDao {
	private SessionFactory sessionFactory;

	public ProjectDaoImpl(SessionFactory sessionFactory) throws DataBaseException {
		if (sessionFactory == null) {
			throw new DataBaseException("sessionFactory is null");
		}
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects(int categoryId) throws DataBaseException {
		List<?> result = sessionFactory.getCurrentSession().createCriteria(Project.class)
				.add(Restrictions.eq("category.id", categoryId)).list();

		check(result);

		return (List<Project>) result;
	}

	@Transactional(readOnly = true)
	@Override
	public Project getProject(int projectId, int categoryId) throws DataBaseException {
		List<?> result = sessionFactory.getCurrentSession().createCriteria(Project.class)
				.add(Restrictions.idEq(projectId)).add(Restrictions.eq("category.id", categoryId)).list();

		check(result);

		return (Project) result.get(0);
	}

	private void check(List<?> result) throws DataBaseException {
		if (result == null || result.isEmpty()) {
			throw new DataBaseException("there is no data in Project table");
		}
	}
}
