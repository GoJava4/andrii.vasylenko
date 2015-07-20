package ua.kiev.avp256.kickstarter_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Quote;
import ua.kiev.avp256.kickstarter_server.service.QuoteService;

@RestController
@RequestMapping(value = "/v1/quote", headers = "Accept=application/json")
public class QuoteController {
	private QuoteService quoteService;

	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public Quote getRandomQuote() {
		return quoteService.loadRandomQuote();
	}

	public void setQuoteService(QuoteService quoteService) {
		this.quoteService = quoteService;
	}
}