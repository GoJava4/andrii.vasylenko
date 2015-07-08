package kickstarter.service;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.PaymentDao;
import kickstarter.dao.PaymentVariantDao;
import kickstarter.dao.ProjectDao;
import kickstarter.entity.Payment;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

public class PaymentService {
	private ProjectDao projectDao;
	private PaymentVariantDao paymentVariantDao;
	private PaymentDao paymentDao;

	@Transactional
	public Payment persistPayment(int projectId, String paymentVariant, String amount) {
		try {
			Project project = projectDao.load(projectId);

			int paymentAmount = getAmount(paymentVariant, amount);

			Payment entity = createEntity(project, paymentAmount);

			paymentDao.persist(entity);

			return entity;

		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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

	private int getAmount(String paymentVariant, String amount) throws DataBaseException {
		if ("other".equals(paymentVariant)) {
			return Integer.parseInt(amount);
		} else {
			int paymentVariantId = Integer.parseInt(paymentVariant);
			return paymentVariantDao.load(paymentVariantId).getAmount();
		}
	}
}
