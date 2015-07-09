package kickstarter.dao.hibernate;

import static org.junit.Assert.*;
import kickstarter.dao.PaymentVariantDao;
import kickstarter.entity.PaymentVariant;
import kickstarter.exception.DataBaseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring-test-context.xml")
public class PaymentVariantDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private PaymentVariantDao paymentVariantDao;
	@Autowired
	private PaymentVariant testPaymentVariant;

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException {
		paymentVariantDao.persist(testPaymentVariant);

		int id = testPaymentVariant.getId();
		PaymentVariant result = paymentVariantDao.load(id);

		assertEquals(1000, result.getAmount());
		assertEquals("testDescription", result.getDescription());
		assertEquals(1, result.getProject().getId());
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		paymentVariantDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		paymentVariantDao.load(-1);
	}
}
