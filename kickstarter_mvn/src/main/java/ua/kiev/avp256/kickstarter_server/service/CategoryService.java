package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.CategoryDao;
import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

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
