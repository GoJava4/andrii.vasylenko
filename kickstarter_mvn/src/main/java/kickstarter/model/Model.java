package kickstarter.model;

import java.sql.SQLException;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public interface Model {
	/**
	 * initialize DAO for current Model
	 */
	void setDao(DAO dao) throws IncorrectInputException;

	/**
	 * get data from DAO and return them
	 */
	Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException, DataBaseException,
			SQLException;
}
