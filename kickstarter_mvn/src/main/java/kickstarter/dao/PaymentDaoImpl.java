package kickstarter.dao;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.Payment;
import kickstarter.exception.IncorrectInputException;

public class PaymentDaoImpl implements PaymentDao {
	private DaoSupport<Payment> daoSupport;

	public PaymentDaoImpl(DaoSupport<Payment> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void addPayment(Payment payment) throws IncorrectInputException {
		daoSupport.addEntity(payment);
	}
}
