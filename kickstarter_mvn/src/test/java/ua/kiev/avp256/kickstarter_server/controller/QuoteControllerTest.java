package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.controller.QuoteController;
import ua.kiev.avp256.kickstarter_server.entity.Quote;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.QuoteService;

public class QuoteControllerTest {
	@Mock
	private QuoteService quoteService;
	@InjectMocks
	private QuoteController welcomeController;
	@Mock
	private Quote quote;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getRandomQuoteTest() {
		when(quoteService.loadRandomQuote()).thenReturn(quote);

		Quote result = welcomeController.getRandomQuote();

		assertEquals(quote, result);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionTest() {
		when(quoteService.loadRandomQuote()).thenThrow(DataNotFoundException.class);

		welcomeController.getRandomQuote();
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionTest() {
		when(quoteService.loadRandomQuote()).thenThrow(RuntimeException.class);

		welcomeController.getRandomQuote();
	}
}
