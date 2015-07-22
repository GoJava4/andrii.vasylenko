package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.exception.InternalServerException;
import ua.kiev.avp256.kickstarter_server.service.PaymentVariantService;

@RestController
@RequestMapping(value = "/v1/payment-variant", headers = "Accept=application/json")
public class PaymentVariantController {
	private static final Logger LOG = LogManager.getLogger(PaymentVariantController.class);

	private PaymentVariantService paymentVariantService;

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public List<PaymentVariant> getPaymentVariantsInProject(@PathVariable int projectId) {
		LOG.entry(projectId);
		try {
			return LOG.exit(paymentVariantService.loadPaymentVariantsInProject(projectId));
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setPaymentVariantService(PaymentVariantService paymentVariantService) {
		this.paymentVariantService = paymentVariantService;
	}
}
