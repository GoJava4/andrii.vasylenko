package ua.kiev.avp256.kickstarter_server.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.dao.PaymentDao;
import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.entity.Payment;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;
import ua.kiev.avp256.kickstarter_server.service.PaymentService;

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
