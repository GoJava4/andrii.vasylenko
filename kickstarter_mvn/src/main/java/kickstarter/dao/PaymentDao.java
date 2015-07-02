package kickstarter.dao;

import kickstarter.entity.Payment;
import kickstarter.exception.IncorrectInputException;

public interface PaymentDao {
	/**
	 * insert payment to DB
	 */
	void addPayment(Payment payment) throws IncorrectInputException;
}
