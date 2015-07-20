package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.service.CategoryService;

@RestController
@RequestMapping(value = "/v1/category", headers = "Accept=application/json")
public class CategoryController {
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categoryService.loadAllCategories();
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
