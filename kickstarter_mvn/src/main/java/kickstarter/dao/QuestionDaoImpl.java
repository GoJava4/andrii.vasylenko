package kickstarter.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class QuestionDaoImpl implements QuestionDao {
	private SessionFactory sessionFactory;

	public QuestionDaoImpl(SessionFactory sessionFactory) throws DataBaseException {
		if (sessionFactory == null) {
			throw new DataBaseException("sessionFactory is null");
		}
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void addQuestion(Question question) throws IncorrectInputException {
		if (question == null) {
			throw new IncorrectInputException("question is null");
		}
		sessionFactory.getCurrentSession().save(question);
	}
}
