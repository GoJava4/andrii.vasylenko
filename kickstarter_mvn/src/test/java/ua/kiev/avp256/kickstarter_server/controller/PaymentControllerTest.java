package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import ua.kiev.avp256.kickstarter_server.controller.PaymentController;
import ua.kiev.avp256.kickstarter_server.entity.Payment;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.PaymentService;

public class PaymentControllerTest {
	@Mock
	private PaymentService paymentService;
	@Autowired
	@InjectMocks
	private PaymentController paymentController;
	@Mock
	private Payment payment;
	private Map<String, String> paymentParameters;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		paymentParameters = new HashMap<>();
	}

	@Test
	public void donateInProjectTest() {
		when(paymentService.persistPayment(anyInt(), anyString(), anyString())).thenReturn(payment);
		paymentParameters.put("paymentVariant", "other");
		paymentParameters.put("amount", "1");

		Payment result = paymentController.donateInProject(0, paymentParameters);

		verify(paymentService, times(1)).persistPayment(0, "other", "1");
		assertEquals(payment, result);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionDonateTest() {
		when(paymentService.persistPayment(anyInt(), anyString(), anyString())).thenThrow(DataNotFoundException.class);

		paymentController.donateInProject(0, paymentParameters);
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionDonateTest() {
		when(paymentService.persistPayment(anyInt(), anyString(), anyString())).thenThrow(RuntimeException.class);

		paymentController.donateInProject(0, paymentParameters);
	}
}
