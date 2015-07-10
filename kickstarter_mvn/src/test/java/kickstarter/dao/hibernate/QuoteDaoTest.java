package kickstarter.dao.hibernate;

import kickstarter.dao.QuoteDao;
import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring-test-context.xml")
public class QuoteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private Quote fakeQuote;

	@Test
	@Rollback(true)
	public void loadTest() throws DataBaseException {
		Quote result = quoteDao.load(1);

		assertEquals("Don't cry because it's over, smile because it happened", result.getQuote());
	}

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException {
		quoteDao.persist(fakeQuote);

		int id = fakeQuote.getId();
		Quote result = quoteDao.load(id);

		assertEquals("testQuote", result.getQuote());
	}

	@Test
	@Rollback(true)
	public void loadRandomTest() throws DataBaseException {
		Quote result = quoteDao.loadRandom();
		assertNotNull(result);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		quoteDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		quoteDao.load(-1);
	}
}
