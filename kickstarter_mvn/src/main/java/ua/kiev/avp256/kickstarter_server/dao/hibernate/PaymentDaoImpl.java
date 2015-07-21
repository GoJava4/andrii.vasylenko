package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import ua.kiev.avp256.kickstarter_server.dao.PaymentDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Payment;

public class PaymentDaoImpl implements PaymentDao {
	private DaoSupport daoSupport;

	@Override
	public void persist(Payment payment) {
		daoSupport.persist(payment);
	}

	@Override
	public Payment load(int id) {
		return daoSupport.load(id, Payment.class);
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
