package kickstarter.dao;

import kickstarter.dao.support.DaoSupport;
import kickstarter.entity.PaymentVariant;
import kickstarter.exception.DataBaseException;

public class PaymentVariantDaoImpl implements PaymentVariantDao {
	private final static String CONDITION_FOR_ONE_ENTITY = "where id = ? and id_project = ?";
	private final static String TABLE_NAME = PaymentVariant.class.getSimpleName();

	private DaoSupport<PaymentVariant> daoSupport;

	public PaymentVariantDaoImpl(DaoSupport<PaymentVariant> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public PaymentVariant getPaymentVariant(int paymentVariantId, int projectId) throws DataBaseException {
		return daoSupport.find(TABLE_NAME, CONDITION_FOR_ONE_ENTITY, 1, paymentVariantId, projectId).get(0);
	}
}
