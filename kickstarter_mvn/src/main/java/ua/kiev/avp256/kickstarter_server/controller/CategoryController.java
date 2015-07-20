package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.InternalServerException;
import ua.kiev.avp256.kickstarter_server.service.CategoryService;

@RestController
@RequestMapping(value = "/v1/category", headers = "Accept=application/json")
public class CategoryController {
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		try {
			return categoryService.loadAllCategories();
		} catch (Exception e) {
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
