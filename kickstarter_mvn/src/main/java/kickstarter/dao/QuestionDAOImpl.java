package kickstarter.dao;

import kickstarter.entity.Question;

public class QuestionDAOImpl extends AbstractDAO<Question> {
	protected QuestionDAOImpl() {
		super("Question", "", "where id_project = ?");
	}
}
