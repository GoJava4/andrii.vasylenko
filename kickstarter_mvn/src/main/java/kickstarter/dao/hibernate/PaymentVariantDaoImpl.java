package kickstarter.dao.hibernate;

import kickstarter.dao.PaymentVariantDao;
import kickstarter.dao.hibernate.support.DaoSupport;
import kickstarter.entity.PaymentVariant;
import kickstarter.exception.DataBaseException;

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
