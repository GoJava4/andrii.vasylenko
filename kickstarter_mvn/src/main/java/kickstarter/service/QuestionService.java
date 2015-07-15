package kickstarter.service;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.ProjectDao;
import kickstarter.dao.QuestionDao;
import kickstarter.entity.Project;
import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;

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
