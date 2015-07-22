package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.exception.InternalServerException;
import ua.kiev.avp256.kickstarter_server.service.CategoryService;

@RestController
@RequestMapping(value = "/v1/category", headers = "Accept=application/json")
public class CategoryController {
	private static final Logger LOG = LogManager.getLogger(CategoryController.class);

	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		LOG.entry();
		try {
			return LOG.exit(categoryService.loadAllCategories());
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
