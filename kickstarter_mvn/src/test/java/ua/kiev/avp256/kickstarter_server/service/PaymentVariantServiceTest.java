package ua.kiev.avp256.kickstarter_server.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;

public class PaymentVariantServiceTest {
	private static final int PROJECT_ID = 1;

	@Mock
	private PaymentVariantDao paymentVariantDao;
	@InjectMocks
	private PaymentVariantService paymentVariantService;
	@Mock
	private List<PaymentVariant> paymentVariants;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loadPaymentVariantsInProjectTest() {
		when(paymentVariantDao.loadPaymentVariantsInProject(anyInt())).thenReturn(paymentVariants);

		List<PaymentVariant> result = paymentVariantService.loadPaymentVariantsInProject(PROJECT_ID);

		assertEquals(paymentVariants, result);
	}
}
