package kickstarter.dao;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Question;
import kickstarter.exception.IncorrectInputException;

public class QuestionDaoImpl implements QuestionDao {
	private DaoSupport<Question> daoSupport;

	public QuestionDaoImpl(DaoSupport<Question> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void addQuestion(Question question) throws IncorrectInputException {
		daoSupport.addEntity(question);
	}
}
