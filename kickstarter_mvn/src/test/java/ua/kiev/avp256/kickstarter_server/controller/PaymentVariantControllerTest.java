package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.PaymentVariantService;

public class PaymentVariantControllerTest {
	@Mock
	private PaymentVariantService paymentVariantService;
	@InjectMocks
	private PaymentVariantController paymentVariantController;
	@Mock
	private List<PaymentVariant> paymentVariants;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getPaymentVariantsInProjectTest() {
		when(paymentVariantService.loadPaymentVariantsInProject(anyInt())).thenReturn(paymentVariants);

		List<PaymentVariant> result = paymentVariantController.getPaymentVariantsInProject(0);

		assertEquals(paymentVariants, result);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionGetTest() {
		when(paymentVariantService.loadPaymentVariantsInProject(anyInt())).thenThrow(DataNotFoundException.class);

		paymentVariantController.getPaymentVariantsInProject(0);
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionGetTest() {
		when(paymentVariantService.loadPaymentVariantsInProject(anyInt())).thenThrow(RuntimeException.class);

		paymentVariantController.getPaymentVariantsInProject(0);
	}
}
