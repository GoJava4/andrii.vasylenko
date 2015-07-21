package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;

public class PaymentVariantService {
	private PaymentVariantDao paymentVariantDao;

	@Transactional(readOnly = true)
	public List<PaymentVariant> loadPaymentVariantsInProject(int projectId) {
		return paymentVariantDao.loadPaymentVariantsInProject(projectId);
	}

	public void setPaymentVariantDao(PaymentVariantDao paymentVariantDao) {
		this.paymentVariantDao = paymentVariantDao;
	}
}
