package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

public class PaymentVariantDaoImpl implements PaymentVariantDao {
	private DaoSupport<PaymentVariant> daoSupport;

	public void setDaoSupport(DaoSupport<PaymentVariant> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void persist(PaymentVariant paymentVariant) throws DataBaseException {
		daoSupport.persist(paymentVariant);
	}

	@Override
	public PaymentVariant load(int id) throws DataBaseException {
		return daoSupport.load(id, PaymentVariant.class);
	}
}
