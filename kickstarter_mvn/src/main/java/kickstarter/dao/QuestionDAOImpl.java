package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Question;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class QuestionDAOImpl extends HibernateDaoSupport implements QuestionDAO {

	@Override
	public void addQuestion(Question question) {
		getHibernateTemplate().save(question);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions(int projectId) {
		return (List<Question>) getHibernateTemplate().find("from Question where id_project = ?", projectId);
	}

}
