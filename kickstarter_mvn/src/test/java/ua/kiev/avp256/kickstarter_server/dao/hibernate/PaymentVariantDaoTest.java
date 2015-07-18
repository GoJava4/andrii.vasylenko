package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

@ContextConfiguration("classpath:hibernate-test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class PaymentVariantDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private PaymentVariantDao paymentVariantDao;
	@Autowired
	private PaymentVariant fakePaymentVariant;

	@Test
	public void loadTest() throws DataBaseException {
		PaymentVariant result = paymentVariantDao.load(1);

		assertEquals(1, result.getProject().getId());
		assertEquals("velo parking", result.getProject().getName());
		assertEquals(10, result.getAmount());
		assertEquals("minimum", result.getDescription());
	}

	@Test
	public void persistTest() throws DataBaseException {
		paymentVariantDao.persist(fakePaymentVariant);

		int id = fakePaymentVariant.getId();
		PaymentVariant result = paymentVariantDao.load(id);

		assertEquals(1000, result.getAmount());
		assertEquals("testDescription", result.getDescription());
		assertEquals(1, result.getProject().getId());
	}

	@Test(expected = DataBaseException.class)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		paymentVariantDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		paymentVariantDao.load(-1);
	}
}
