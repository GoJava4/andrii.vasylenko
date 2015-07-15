package kickstarter.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.CategoryDao;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

public class CategoryService {
	private CategoryDao categoryDao;

	@Transactional(readOnly = true)
	public List<Category> loadAllCategories() {
		try {
			return categoryDao.loadAll();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
}
