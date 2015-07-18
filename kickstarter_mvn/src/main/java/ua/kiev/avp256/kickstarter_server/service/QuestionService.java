package ua.kiev.avp256.kickstarter_server.service;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class QuestionService {
	private ProjectDao projectDao;
	private QuestionDao questionDao;

	@Transactional
	public Question persistQuestion(int projectId, String question) {
		try {
			Project project = projectDao.load(projectId);

			Question entity = createEntity(project, question);

			questionDao.persist(entity);

			return entity;

		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	private Question createEntity(Project project, String question) {
		Question entity = new Question();
		entity.setProject(project);
		entity.setQuestion(question);
		return entity;
	}
}
