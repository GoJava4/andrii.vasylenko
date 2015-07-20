package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Question;

public class QuestionDaoImpl implements QuestionDao {
	private DaoSupport<Question> daoSupport;

	public void setDaoSupport(DaoSupport<Question> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void persist(Question question) {
		daoSupport.persist(question);
	}

	@Override
	public Question load(int id) {
		return daoSupport.load(id, Question.class);
	}
}
