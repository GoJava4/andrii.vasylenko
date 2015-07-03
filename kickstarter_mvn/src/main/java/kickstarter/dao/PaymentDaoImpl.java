package kickstarter.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import kickstarter.entity.Payment;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class PaymentDaoImpl implements PaymentDao {
	private SessionFactory sessionFactory;

	public PaymentDaoImpl(SessionFactory sessionFactory) throws DataBaseException {
		if (sessionFactory == null) {
			throw new DataBaseException("sessionFactory is null");
		}
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void addPayment(Payment payment) throws IncorrectInputException {
		if (payment == null) {
			throw new IncorrectInputException("payment is null");
		}
		sessionFactory.getCurrentSession().save(payment);
	}
}
