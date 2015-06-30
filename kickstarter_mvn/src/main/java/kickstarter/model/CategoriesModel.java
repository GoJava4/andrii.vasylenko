package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.DAO;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class CategoriesModel implements Model {
	private DAO<Category> categoryDAO;

	public void setCategoryDAO(DAO<Category> categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("categories", categoryDAO.getEntities());

		return result;
	}
}
