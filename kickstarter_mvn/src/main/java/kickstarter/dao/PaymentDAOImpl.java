package kickstarter.dao;

import kickstarter.entity.Payment;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class PaymentDAOImpl extends HibernateDaoSupport implements PaymentDAO {

	@Override
	public void addPayment(Payment payment) {
		getHibernateTemplate().save(payment);
	}

}
