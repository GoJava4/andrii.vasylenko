package kickstarter.dao.hibernate;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.PaymentDao;
import kickstarter.dao.hibernate.support.DaoSupport;
import kickstarter.entity.Payment;
import kickstarter.exception.DataBaseException;

public class PaymentDaoImpl implements PaymentDao {
	private DaoSupport<Payment> daoSupport;

	public void setDaoSupport(DaoSupport<Payment> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Transactional
	@Override
	public void persist(Payment payment) throws DataBaseException {
		daoSupport.persist(payment);
	}

	@Transactional(readOnly = true)
	@Override
	public Payment load(int id) throws DataBaseException {
		return daoSupport.load(id, Payment.class);
	}
}
