package kickstarter.dao.hibernate;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.QuestionDao;
import kickstarter.dao.hibernate.support.DaoSupport;
import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;

public class QuestionDaoImpl implements QuestionDao {
	private DaoSupport<Question> daoSupport;

	public void setDaoSupport(DaoSupport<Question> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Transactional
	@Override
	public void persist(Question question) throws DataBaseException {
		daoSupport.persist(question);
	}

	@Transactional(readOnly = true)
	@Override
	public Question load(int id) throws DataBaseException {
		return daoSupport.load(id, Question.class);
	}
}