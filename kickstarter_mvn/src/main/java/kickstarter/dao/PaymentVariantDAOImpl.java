package kickstarter.dao;

import kickstarter.entity.PaymentVariant;

public class PaymentVariantDAOImpl extends AbstractDAO<PaymentVariant> {
	protected PaymentVariantDAOImpl() {
		super("PaymentVariant", "where id = ? and id_project = ?", "where id_project = ?");
	}
}
