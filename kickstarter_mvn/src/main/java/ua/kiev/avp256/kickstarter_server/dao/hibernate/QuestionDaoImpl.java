package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class QuestionDaoImpl implements QuestionDao {
	private DaoSupport<Question> daoSupport;

	public void setDaoSupport(DaoSupport<Question> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void persist(Question question) throws DataBaseException {
		daoSupport.persist(question);
	}

	@Override
	public Question load(int id) throws DataBaseException {
		return daoSupport.load(id, Question.class);
	}
}
