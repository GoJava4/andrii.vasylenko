package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Question;

public interface QuestionDAO {
	void addQuestion(Question question);

	List<Question> getQuestions(int projectId);
}
