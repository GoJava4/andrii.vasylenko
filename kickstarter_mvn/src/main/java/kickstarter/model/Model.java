package kickstarter.model;

import java.sql.SQLException;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public interface Model {
	/**
	 * get data from DAO and return them
	 */
	Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException, DataBaseException,
			SQLException;
}
