package kickstarter.dao;

import java.util.List;

import kickstarter.entity.PaymentVariant;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class PaymentVariantDao extends AbstractDao<PaymentVariant> {
	private final static String CONDITION_FOR_LIST_OF_ENTITIES = "where id_project = ?";
	private final static String CONDITION_FOR_ONE_ENTITY = "where id = ? and id_project = ?";

	/**
	 * expect one parameter - id of project
	 */
	@Override
	public List<PaymentVariant> getEntities(Object... parameters) throws DataBaseException, IncorrectInputException {
		int projectId = getIntParameter(0, parameters);
		return find(CONDITION_FOR_LIST_OF_ENTITIES, 0, projectId);
	}

	/**
	 * expect two parameters: 0 - id of payment variant, 1 - id of project
	 */
	@Override
	public PaymentVariant getEntity(Object... parameters) throws DataBaseException, IncorrectInputException {
		int paymentVariantId = getIntParameter(0, parameters);
		int projectId = getIntParameter(1, parameters);
		return find(CONDITION_FOR_ONE_ENTITY, 1, paymentVariantId, projectId).get(0);
	}

	@Override
	protected String getTableName() {
		return PaymentVariant.class.getSimpleName();
	}
}
