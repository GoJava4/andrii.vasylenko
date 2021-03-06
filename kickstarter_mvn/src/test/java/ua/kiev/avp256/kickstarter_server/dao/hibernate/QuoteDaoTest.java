package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.kiev.avp256.kickstarter_server.dao.QuoteDao;
import ua.kiev.avp256.kickstarter_server.entity.Quote;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;

@ContextConfiguration("classpath:hibernate-test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class QuoteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private Quote fakeQuote;

	@Test
	public void loadTest() {
		Quote result = quoteDao.load(1);

		assertEquals("Don't cry because it's over, smile because it happened", result.getQuote());
	}

	@Test
	public void persistTest() {
		quoteDao.persist(fakeQuote);

		int id = fakeQuote.getId();
		Quote result = quoteDao.load(id);

		assertEquals("testQuote", result.getQuote());
	}

	@Test
	public void loadRandomTest() {
		Quote result = quoteDao.loadRandom();
		assertNotNull(result);
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenPersistNull() {
		quoteDao.persist(null);
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenIncorrectId() {
		quoteDao.load(-1);
	}
}
