package kickstarter.dao;

import kickstarter.entity.PaymentVariant;
import kickstarter.exception.DataBaseException;

public interface PaymentVariantDao {
	/**
	 * return payment variant from DB
	 * 
	 * @param paymentVariantId
	 *            - id of payment variant
	 * @param projectId
	 *            - id of project which linked to payment variant
	 */
	PaymentVariant getPaymentVariant(int paymentVariantId, int projectId) throws DataBaseException;
}
