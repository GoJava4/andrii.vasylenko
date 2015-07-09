package kickstarter.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import kickstarter.dao.PaymentDao;
import kickstarter.dao.PaymentVariantDao;
import kickstarter.dao.ProjectDao;
import kickstarter.entity.Payment;
import kickstarter.entity.PaymentVariant;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test-context.xml")
public class PaymentServiceTest {
	@Mock
	private Project project;
	@Mock
	private PaymentVariant paymentVariant;
	@Mock
	private ProjectDao projectDao;
	@Mock
	private PaymentVariantDao paymentVariantDao;
	@Mock
	private PaymentDao paymentDao;
	@InjectMocks
	private PaymentService paymentService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldPersistInputAmount_whenPaymentVariantIsOther() throws DataBaseException {
		when(projectDao.load(anyInt())).thenReturn(project);
		when(paymentVariantDao.load(anyInt())).thenReturn(paymentVariant);
		when(paymentVariant.getAmount()).thenReturn(10000);

		Payment result = paymentService.persistPayment(0, "other", "1000");

		verify(paymentVariantDao, never()).load(anyInt());
		verify(paymentDao, times(1)).persist(result);
		assertEquals(project, result.getProject());
		assertEquals(1000, result.getAmount());
	}

	@Test
	public void shouldPersistAmountFromPaymentVariant_whenPaymentVariantIsNotOther() throws DataBaseException {
		when(projectDao.load(anyInt())).thenReturn(project);
		when(paymentVariantDao.load(anyInt())).thenReturn(paymentVariant);
		when(paymentVariant.getAmount()).thenReturn(10000);

		Payment result = paymentService.persistPayment(0, "1", "");

		verify(paymentVariantDao, times(1)).load(anyInt());
		verify(paymentDao, times(1)).persist(result);
		assertEquals(project, result.getProject());
		assertEquals(10000, result.getAmount());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnNull_whenDataBaseException() throws DataBaseException {
		when(projectDao.load(anyInt())).thenThrow(DataBaseException.class);
		when(paymentVariantDao.load(anyInt())).thenReturn(paymentVariant);
		when(paymentVariant.getAmount()).thenReturn(10000);

		assertNull(paymentService.persistPayment(0, "1", ""));
	}
}
