package kickstarter.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import kickstarter.entity.Payment;
import kickstarter.service.PaymentService;
import kickstarter.service.ProjectService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test-context.xml")
public class DonateControllerTest {
	@Mock
	private ProjectService projectService;
	@Mock
	private PaymentService paymentService;
	@Mock
	private Model model;
	@Mock
	private Payment payment;
	@Autowired
	@InjectMocks
	private DonateController donateController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showDonatePageTest() {
		when(projectService.loadProject(anyInt())).thenReturn(null);

		String result = donateController.showDonatePage(model, 0);

		verify(model, times(1)).addAttribute("project", null);
		assertEquals("Donate", result);
	}

	@Test
	public void submitDonatePageTest() {
		when(paymentService.persistPayment(anyInt(), anyString(), anyString())).thenReturn(payment);

		String result = donateController.submitDonatePage(model, 0, "", "");

		verify(model, times(1)).addAttribute("project", null);
		assertEquals("DonateSubmit", result);
	}
}
