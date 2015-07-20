package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.kiev.avp256.kickstarter_server.dao.PaymentDao;
import ua.kiev.avp256.kickstarter_server.entity.Payment;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;

@ContextConfiguration("classpath:hibernate-test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class PaymentDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private Payment fakePayment;

	@Test
	public void loadTest() {
		Payment result = paymentDao.load(1);

		assertEquals(1, result.getProject().getId());
		assertEquals("velo parking", result.getProject().getName());
		assertEquals(500, result.getAmount());
	}

	@Test
	public void persistTest() {
		paymentDao.persist(fakePayment);

		int id = fakePayment.getId();
		Payment result = paymentDao.load(id);

		assertEquals(1000, result.getAmount());
		assertEquals(1, result.getProject().getId());
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenPersistNull() {
		paymentDao.persist(null);
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenIncorrectId() {
		paymentDao.load(-1);
	}
}
