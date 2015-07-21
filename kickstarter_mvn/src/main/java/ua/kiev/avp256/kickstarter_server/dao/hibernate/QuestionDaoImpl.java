package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Question;

public class QuestionDaoImpl implements QuestionDao {
	private DaoSupport daoSupport;

	@Override
	public void persist(Question question) {
		daoSupport.persist(question);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Question> loadQuestionsInProject(int projectId) {
		List<?> result = daoSupport.getCurrentSession().createCriteria(Question.class)
				.add(Restrictions.eq("project.id", projectId)).list();

		daoSupport.check(result);

		return (List<Question>) result;
	}

	@Override
	public Question load(int id) {
		return daoSupport.load(id, Question.class);
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
