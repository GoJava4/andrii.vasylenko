package kickstarter.dao;

import kickstarter.entity.Payment;

public class PaymentDAOImpl extends AbstractDAO<Payment> {
	protected PaymentDAOImpl() {
		super("Payment", "", "");
	}
}
