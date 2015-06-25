package kickstarter.dao;

import java.sql.SQLException;

import kickstarter.dao.sub.CategoriesDAO;
import kickstarter.dao.sub.PaymentsDAO;
import kickstarter.dao.sub.ProjectsDAO;
import kickstarter.dao.sub.QuestionsDAO;
import kickstarter.dao.sub.QuotesDAO;
import kickstarter.exception.DataBaseException;

public interface DAO extends QuotesDAO, CategoriesDAO, ProjectsDAO, QuestionsDAO, PaymentsDAO {
	/**
	 * add create all tables in BD and add test data in the tables
	 */
	void initData() throws DataBaseException, SQLException;
}
