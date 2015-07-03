package kickstarter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import kickstarter.entity.PaymentVariant;
import kickstarter.exception.DataBaseException;

public class PaymentVariantDaoImpl implements PaymentVariantDao {
	private SessionFactory sessionFactory;

	public PaymentVariantDaoImpl(SessionFactory sessionFactory) throws DataBaseException {
		if (sessionFactory == null) {
			throw new DataBaseException("sessionFactory is null");
		}
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@Override
	public PaymentVariant getPaymentVariant(int paymentVariantId, int projectId) throws DataBaseException {
		List<?> result = sessionFactory.getCurrentSession().createCriteria(PaymentVariant.class)
				.add(Restrictions.idEq(paymentVariantId)).add(Restrictions.eq("project.id", projectId)).list();

		check(result);

		return (PaymentVariant) result.get(0);
	}

	private void check(List<?> result) throws DataBaseException {
		if (result == null || result.isEmpty()) {
			throw new DataBaseException("there is no data in quote table");
		}
	}
}
