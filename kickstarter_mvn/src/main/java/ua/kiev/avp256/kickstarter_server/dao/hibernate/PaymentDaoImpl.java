package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.kiev.avp256.kickstarter_server.dao.PaymentDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Payment;

public class PaymentDaoImpl implements PaymentDao {
	private static final Logger LOG = LogManager.getLogger(PaymentDaoImpl.class);

	private DaoSupport daoSupport;

	@Override
	public void persist(Payment payment) {
		LOG.entry(payment);
		daoSupport.persist(payment);
		LOG.exit();
	}

	@Override
	public Payment load(int id) {
		LOG.entry(id);
		return LOG.exit(daoSupport.load(id, Payment.class));
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
