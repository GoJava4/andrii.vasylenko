package kickstarter.dao.hibernate;

import static org.junit.Assert.*;

import kickstarter.dao.PaymentDao;
import kickstarter.entity.Payment;
import kickstarter.exception.DataBaseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring-test-context.xml")
public class PaymentDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private Payment testPayment;

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException {
		paymentDao.persist(testPayment);

		int id = testPayment.getId();
		Payment result = paymentDao.load(id);

		assertEquals(1000, result.getAmount());
		assertEquals(1, result.getProject().getId());
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		paymentDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		paymentDao.load(-1);
	}
}