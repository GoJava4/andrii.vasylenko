package kickstarter.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.PaymentVariant;
import kickstarter.exception.DataBaseException;

public class PaymentVariantDaoImpl implements PaymentVariantDao {
	private DaoSupport<PaymentVariant> daoSupport;

	public PaymentVariantDaoImpl(DaoSupport<PaymentVariant> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public PaymentVariant getPaymentVariant(int paymentVariantId, int projectId) throws DataBaseException {
		DetachedCriteria criteria = DetachedCriteria.forClass(PaymentVariant.class);
		criteria.add(Restrictions.idEq(paymentVariantId));
		criteria.add(Restrictions.eq("project.id", projectId));
		return daoSupport.find(criteria).get(0);
	}
}
