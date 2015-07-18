package ua.kiev.avp256.kickstarter_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.kiev.avp256.kickstarter_server.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	private CategoryService categoryService;
	private String view;

	@RequestMapping(method = RequestMethod.GET)
	public String showCategoriesPage(Model model) {
		model.addAttribute("categories", categoryService.loadAllCategories());
		return view;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setView(String view) {
		this.view = view;
	}
}
