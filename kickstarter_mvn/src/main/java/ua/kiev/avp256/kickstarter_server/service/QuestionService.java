package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.entity.Question;

public class QuestionService {
	private ProjectDao projectDao;
	private QuestionDao questionDao;

	@Transactional(readOnly = true)
	public List<Question> loadQuestionsInProject(int projectId) {
		return questionDao.loadQuestionsInProject(projectId);
	}

	@Transactional
	public Question persistQuestion(int projectId, String question) {
		Project project = projectDao.load(projectId);

		Question entity = createEntity(project, question);

		questionDao.persist(entity);

		return entity;
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
