package ua.kiev.avp256.kickstarter_server.dao;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.entity.Question;

public interface QuestionDao extends GenericDao<Question> {
	/**
	 * return all questions in project where 'id' = 'projectId'
	 * 
	 * @param projectId
	 *            - id of project which linked to list of questions
	 * 
	 * @throws DataNotFoundException
	 *             when there are no any question in project
	 */
	List<Question> loadQuestionsInProject(int projectId);
}
