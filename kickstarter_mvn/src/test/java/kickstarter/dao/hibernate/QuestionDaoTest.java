package kickstarter.dao.hibernate;

import static org.junit.Assert.*;
import kickstarter.dao.QuestionDao;
import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring-test-context.xml")
public class QuestionDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private Question fakeQuestion;

	@Test
	@Rollback(true)
	public void loadTest() throws DataBaseException {
		Question result = questionDao.load(1);

		assertEquals(1, result.getProject().getId());
		assertEquals("velo parking", result.getProject().getName());
		assertEquals("WTF №1?", result.getQuestion());
	}

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException {
		questionDao.persist(fakeQuestion);

		int id = fakeQuestion.getId();
		Question result = questionDao.load(id);

		assertEquals("testQuestion", result.getQuestion());
		assertEquals(1, result.getProject().getId());
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		questionDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		questionDao.load(-1);
	}
}
