package kickstarter.controller;

import kickstarter.service.QuoteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WelcomeController {
	private QuoteService quoteService;
	private String view;

	@RequestMapping(method = RequestMethod.GET)
	public String showWelcomePage(Model model) {
		model.addAttribute("quote", quoteService.loadRandomQuote());
		return view;
	}

	public void setQuoteService(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	public void setView(String view) {
		this.view = view;
	}
}
