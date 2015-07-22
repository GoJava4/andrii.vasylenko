package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.entity.Question;

public class QuestionService {
	private static final Logger LOG = LogManager.getLogger(QuestionService.class);

	private ProjectDao projectDao;
	private QuestionDao questionDao;

	@Transactional(readOnly = true)
	public List<Question> loadQuestionsInProject(int projectId) {
		LOG.entry(projectId);
		return LOG.exit(questionDao.loadQuestionsInProject(projectId));
	}

	@Transactional
	public Question persistQuestion(int projectId, String question) {
		LOG.entry(projectId, question);

		Project project = projectDao.load(projectId);

		Question entity = createEntity(project, question);

		questionDao.persist(entity);

		return LOG.exit(entity);
	}

	private Question createEntity(Project project, String question) {
		LOG.entry(project, question);
		Question entity = new Question();
		entity.setProject(project);
		entity.setQuestion(question);
		return LOG.exit(entity);
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
}
