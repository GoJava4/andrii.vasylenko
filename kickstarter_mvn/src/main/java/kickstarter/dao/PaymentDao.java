package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Payment;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class PaymentDao extends AbstractDao<Payment> {
	private final static String CONDITION_FOR_LIST_OF_ENTITIES = "where id_project = ?";
	private final static String CONDITION_FOR_ONE_ENTITY = "where id = ? and id_project = ?";

	/**
	 * expect one parameter - id of project
	 */
	@Override
	public List<Payment> getEntities(Object... parameters) throws DataBaseException, IncorrectInputException {
		int projectId = getIntParameter(0, parameters);
		return find(CONDITION_FOR_LIST_OF_ENTITIES, 0, projectId);
	}

	/**
	 * expect two parameters: 0 - id of payment, 1 - id of project
	 */
	@Override
	public Payment getEntity(Object... parameters) throws DataBaseException, IncorrectInputException {
		int paymentId = getIntParameter(0, parameters);
		int projectId = getIntParameter(1, parameters);
		return find(CONDITION_FOR_ONE_ENTITY, 1, paymentId, projectId).get(0);
	}

	@Override
	protected String getTableName() {
		return Payment.class.getSimpleName();
	}
}
