package kickstarter.model;

import kickstarter.dao.DAO;
import kickstarter.exception.IncorrectInputException;

public abstract class AbstractModel implements Model {
	private DAO dao;

	@Override
	public void setDao(DAO dao) throws IncorrectInputException {
		if (dao == null) {
			throw new IncorrectInputException("can not init: dao is null");
		}
		this.dao = dao;
	}

	protected DAO getDao() {
		return dao;
	}

	protected int getInt(String[] parameter) {
		return Integer.parseInt(getString(parameter));
	}

	protected String getString(String[] parameter) {
		return parameter[0];
	}
}
