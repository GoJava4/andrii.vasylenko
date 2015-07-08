package kickstarter.dao.hibernate;

import kickstarter.dao.QuestionDao;
import kickstarter.dao.hibernate.support.DaoSupport;
import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;

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
