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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PaymentServiceTest {
	private static final int PROJECT_ID = 1;
	private static final String PAYMENT_VARIANT_ID = "1";
	private static final String PAYMENT_VARIANT_OTHER = "other";
	private static final int PAYMENT_AMOUNT = 10000;
	private static final int PAYMENT_AMOUNT_OTHER = 1000;

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
		when(paymentVariant.getAmount()).thenReturn(PAYMENT_AMOUNT);

		Payment result = paymentService.persistPayment(PROJECT_ID, PAYMENT_VARIANT_OTHER, "" + PAYMENT_AMOUNT_OTHER);

		verify(paymentVariantDao, never()).load(anyInt());
		verify(paymentDao, times(1)).persist(result);
		assertEquals(project, result.getProject());
		assertEquals(PAYMENT_AMOUNT_OTHER, result.getAmount());
	}

	@Test
	public void shouldPersistAmountFromPaymentVariant_whenPaymentVariantIsNotOther() throws DataBaseException {
		when(projectDao.load(anyInt())).thenReturn(project);
		when(paymentVariantDao.load(anyInt())).thenReturn(paymentVariant);
		when(paymentVariant.getAmount()).thenReturn(PAYMENT_AMOUNT);

		Payment result = paymentService.persistPayment(PROJECT_ID, PAYMENT_VARIANT_ID, "");

		verify(paymentVariantDao, times(1)).load(anyInt());
		verify(paymentDao, times(1)).persist(result);
		assertEquals(project, result.getProject());
		assertEquals(PAYMENT_AMOUNT, result.getAmount());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnNull_whenDataBaseException() throws DataBaseException {
		when(projectDao.load(anyInt())).thenThrow(DataBaseException.class);
		when(paymentVariantDao.load(anyInt())).thenReturn(paymentVariant);
		when(paymentVariant.getAmount()).thenReturn(PAYMENT_AMOUNT);

		assertNull(paymentService.persistPayment(PROJECT_ID, PAYMENT_VARIANT_ID, ""));
	}
}
