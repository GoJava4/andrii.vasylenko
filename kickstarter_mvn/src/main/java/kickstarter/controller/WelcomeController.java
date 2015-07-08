package kickstarter.controller;

import kickstarter.service.QuoteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	private QuoteService quoteService;
	private String view;

	public void setQuoteService(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	public void setView(String view) {
		this.view = view;
	}

	@RequestMapping("/")
	public String showWelcomePage(Model model) {
		model.addAttribute("quote", quoteService.loadRandomQuote());
		return view;
	}
}
