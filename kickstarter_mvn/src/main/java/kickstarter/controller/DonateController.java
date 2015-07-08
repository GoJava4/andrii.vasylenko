package kickstarter.controller;

import kickstarter.entity.Payment;
import kickstarter.service.PaymentService;
import kickstarter.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DonateController {
	private ProjectService projectService;
	private PaymentService paymentService;
	private String view;
	private String submitView;

	@RequestMapping(value = "/donate", method = RequestMethod.GET)
	public String showDonatePage(Model model, @RequestParam("project") int projectId) {
		model.addAttribute("project", projectService.loadProject(projectId));
		return view;
	}

	@RequestMapping(value = "/donate_submit", method = RequestMethod.POST)
	public String submitDonatePage(Model model, @RequestParam("project") int projectId,
			@RequestParam("paymentVariant") String paymentVariant, @RequestParam("amount") String amount) {

		Payment persistPayment = paymentService.persistPayment(projectId, paymentVariant, amount);
		model.addAttribute("project", persistPayment.getProject());

		return submitView;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void setView(String view) {
		this.view = view;
	}

	public void setSubmitView(String submitView) {
		this.submitView = submitView;
	}
}
