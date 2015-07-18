package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

import ua.kiev.avp256.kickstarter_server.controller.WelcomeController;
import ua.kiev.avp256.kickstarter_server.service.QuoteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mvc-context.xml")
public class WelcomeControllerTest {
	private static final String VIEW = "Quote";

	@Mock
	private QuoteService quoteService;
	@Mock
	private Model model;
	@Autowired
	@InjectMocks
	private WelcomeController welcomeController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showWelcomePageTest() {
		when(quoteService.loadRandomQuote()).thenReturn(null);

		String result = welcomeController.showWelcomePage(model);

		verify(model, times(1)).addAttribute("quote", null);
		assertEquals(VIEW, result);
	}
}
