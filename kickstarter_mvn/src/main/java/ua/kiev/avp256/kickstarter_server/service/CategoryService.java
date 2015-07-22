package ua.kiev.avp256.kickstarter_server.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.avp256.kickstarter_server.dao.CategoryDao;
import ua.kiev.avp256.kickstarter_server.entity.Category;

public class CategoryService {
	private static final Logger LOG = LogManager.getLogger(CategoryService.class);

	private CategoryDao categoryDao;

	@Transactional(readOnly = true)
	public List<Category> loadAllCategories() {
		LOG.entry();
		return LOG.exit(categoryDao.loadAll());
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
}
