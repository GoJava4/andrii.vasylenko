package ua.kiev.avp256.kickstarter_server.dao;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;

public interface PaymentVariantDao extends GenericDao<PaymentVariant> {
	/**
	 * return all Payment Variants in project where 'id' = 'projectId'
	 * 
	 * @param projectId
	 *            - id of project which linked to list of Payment Variants
	 * 
	 * @throws DataNotFoundException
	 *             when there are no any Payment Variant in project
	 */
	List<PaymentVariant> loadPaymentVariantsInProject(int projectId);
}
