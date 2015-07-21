package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;

@ContextConfiguration("classpath:hibernate-test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class QuestionDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private Question fakeQuestion;

	@Test
	public void loadTest() {
		Question result = questionDao.load(1);

		assertEquals(1, result.getProject().getId());
		assertEquals("velo parking", result.getProject().getName());
		assertEquals("Question 1?", result.getQuestion());
	}

	@Test
	public void loadQuestionsInProjectTest() {
		List<Question> result = questionDao.loadQuestionsInProject(1);
		assertEquals(1, result.size());
	}

	@Test
	public void persistTest() {
		questionDao.persist(fakeQuestion);

		int id = fakeQuestion.getId();
		Question result = questionDao.load(id);

		assertEquals("testQuestion", result.getQuestion());
		assertEquals(1, result.getProject().getId());
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenPersistNull() {
		questionDao.persist(null);
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenIncorrectId() {
		questionDao.load(-1);
	}
}
