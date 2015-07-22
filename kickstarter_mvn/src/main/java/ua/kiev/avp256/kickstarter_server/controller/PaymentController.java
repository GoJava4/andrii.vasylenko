package ua.kiev.avp256.kickstarter_server.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger LOG = LogManager.getLogger(PaymentController.class);

	private PaymentService paymentService;

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.POST)
	public Payment donateInProject(@PathVariable int projectId, @RequestBody Map<String, String> paymentParameters) {
		LOG.entry(projectId, paymentParameters);
		try {
			return LOG.exit(paymentService.persistPayment(projectId, paymentParameters.get("paymentVariant"),
					paymentParameters.get("amount")));
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
}
