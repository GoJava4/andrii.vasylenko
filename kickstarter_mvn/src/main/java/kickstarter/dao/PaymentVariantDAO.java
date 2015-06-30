package kickstarter.dao;

import kickstarter.entity.PaymentVariant;

public interface PaymentVariantDAO {
	PaymentVariant getPaymentVariant(int id, int projectId);
}
