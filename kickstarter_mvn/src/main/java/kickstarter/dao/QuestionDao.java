package kickstarter.dao;

import kickstarter.entity.Question;
import kickstarter.exception.IncorrectInputException;

public interface QuestionDao {
	/**
	 * insert question to DB
	 */
	void addQuestion(Question question) throws IncorrectInputException;
}
