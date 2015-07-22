package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Question;

public class QuestionDaoImpl implements QuestionDao {
	private static final Logger LOG = LogManager.getLogger(QuestionDaoImpl.class);

	private DaoSupport daoSupport;

	@Override
	public void persist(Question question) {
		LOG.entry(question);
		daoSupport.persist(question);
		LOG.exit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Question> loadQuestionsInProject(int projectId) {
		LOG.entry(projectId);

		List<?> result = daoSupport.getCurrentSession().createCriteria(Question.class)
				.add(Restrictions.eq("project.id", projectId)).list();

		daoSupport.check(result);

		return LOG.exit((List<Question>) result);
	}

	@Override
	public Question load(int id) {
		LOG.entry(id);
		return LOG.exit(daoSupport.load(id, Question.class));
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
