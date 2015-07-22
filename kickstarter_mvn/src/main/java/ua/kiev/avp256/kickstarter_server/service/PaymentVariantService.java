package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;

public class PaymentVariantService {
	private static final Logger LOG = LogManager.getLogger(PaymentVariantService.class);

	private PaymentVariantDao paymentVariantDao;

	@Transactional(readOnly = true)
	public List<PaymentVariant> loadPaymentVariantsInProject(int projectId) {
		LOG.entry(projectId);
		return LOG.exit(paymentVariantDao.loadPaymentVariantsInProject(projectId));
	}

	public void setPaymentVariantDao(PaymentVariantDao paymentVariantDao) {
		this.paymentVariantDao = paymentVariantDao;
	}
}
