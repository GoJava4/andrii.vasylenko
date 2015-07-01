package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Payment;
import kickstarter.exception.DataBaseException;

public class PaymentDao extends AbstractDao<Payment> {

	/**
	 * do not need any parameters
	 */
	@Override
	public List<Payment> getEntities(Object... parameters) throws DataBaseException {
		return find("", 0);
	}

	/**
	 * do not need any parameters
	 */
	@Override
	public Payment getEntity(Object... parameters) throws DataBaseException {
		return find("", 1).get(0);
	}

	@Override
	protected String getTableName() {
		return Payment.class.getSimpleName();
	}
}
