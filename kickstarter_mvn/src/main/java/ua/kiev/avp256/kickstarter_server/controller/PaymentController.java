package ua.kiev.avp256.kickstarter_server.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Payment;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.exception.InternalServerException;
import ua.kiev.avp256.kickstarter_server.service.PaymentService;

@RestController
@RequestMapping(value = "/v1/payment", headers = "Accept=application/json")
public class PaymentController {
	private PaymentService paymentService;

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.POST)
	public Payment donateInProject(@PathVariable int projectId, @RequestBody Map<String, String> paymentParameters) {
		try {
			return paymentService.persistPayment(projectId, paymentParameters.get("paymentVariant"),
					paymentParameters.get("amount"));
		} catch (DataNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
}
