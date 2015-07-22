package ua.kiev.avp256.kickstarter_server.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Quote;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.exception.InternalServerException;
import ua.kiev.avp256.kickstarter_server.service.QuoteService;

@RestController
@RequestMapping(value = "/v1/quote", headers = "Accept=application/json")
public class QuoteController {
	private static final Logger LOG = LogManager.getLogger(QuoteController.class);

	private QuoteService quoteService;

	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public Quote getRandomQuote() {
		LOG.entry();
		try {
			return LOG.exit(quoteService.loadRandomQuote());
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setQuoteService(QuoteService quoteService) {
		this.quoteService = quoteService;
	}
}
