package ua.kiev.avp256.kickstarter_server.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.dao.QuoteDao;
import ua.kiev.avp256.kickstarter_server.entity.Quote;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.QuoteService;

public class QuoteServiceTest {
	@Mock
	private Quote quote;
	@Mock
	private QuoteDao quoteDao;
	@InjectMocks
	private QuoteService quoteService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loadRandomQuoteTest() {
		when(quoteDao.loadRandom()).thenReturn(quote);

		Quote result = quoteService.loadRandomQuote();

		assertEquals(quote, result);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void throwExceptionTest() {
		when(quoteDao.loadRandom()).thenThrow(DataNotFoundException.class);

		quoteService.loadRandomQuote();
	}
}
