package kickstarter.dao;

import java.util.List;

import kickstarter.entity.PaymentVariant;

public interface PaymentVariantDAO {
	PaymentVariant getPaymentVariant(int id, int projectId);

	List<PaymentVariant> getPaymentVariants(int projectId);
}
