package ua.kiev.avp256.kickstarter_server.service;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.PaymentDao;
import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.entity.Payment;
import ua.kiev.avp256.kickstarter_server.entity.Project;

public class PaymentService {
	private ProjectDao projectDao;
	private PaymentVariantDao paymentVariantDao;
	private PaymentDao paymentDao;

	@Transactional
	public Payment persistPayment(int projectId, String paymentVariant, String amount) {
		Project project = projectDao.load(projectId);

		int paymentAmount = getAmount(paymentVariant, amount);

		Payment entity = createEntity(project, paymentAmount);

		paymentDao.persist(entity);

		return entity;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setPaymentVariantDao(PaymentVariantDao paymentVariantDao) {
		this.paymentVariantDao = paymentVariantDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	private Payment createEntity(Project project, int amount) {
		Payment payment = new Payment();
		payment.setProject(project);
		payment.setAmount(amount);
		return payment;
	}

	private int getAmount(String paymentVariant, String amount) {
		if ("other".equals(paymentVariant)) {
			return Integer.parseInt(amount);
		} else {
			int paymentVariantId = Integer.parseInt(paymentVariant);
			return paymentVariantDao.load(paymentVariantId).getAmount();
		}
	}
}
