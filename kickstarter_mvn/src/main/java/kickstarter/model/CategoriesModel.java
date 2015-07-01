package kickstarter.model;

import java.util.HashMap;
import java.util.Map;

import kickstarter.dao.Dao;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

public class CategoriesModel implements Model {
	private Dao<Category> categoryDao;

	public void setCategoryDao(Dao<Category> categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Map<String, Object> getData(Map<String, String[]> parameters) throws IncorrectInputException,
			DataBaseException {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("categories", categoryDao.getEntities());

		return result;
	}
}
