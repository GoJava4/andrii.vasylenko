package kickstarter.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import kickstarter.dao.QuoteDao;
import kickstarter.entity.Quote;
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
	public void loadRandomQuoteTest() throws DataBaseException {
		when(quoteDao.loadRandom()).thenReturn(quote);

		Quote result = quoteService.loadRandomQuote();

		assertEquals(quote, result);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnNull_whenDataBaseException() throws DataBaseException {
		when(quoteDao.loadRandom()).thenThrow(DataBaseException.class);

		Quote result = quoteService.loadRandomQuote();

		assertNull(result);
	}
}
