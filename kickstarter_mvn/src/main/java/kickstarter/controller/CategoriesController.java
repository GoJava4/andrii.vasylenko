package kickstarter.controller;

import kickstarter.service.CategoryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoriesController {
	private CategoryService categoryService;
	private String view;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setView(String view) {
		this.view = view;
	}

	@RequestMapping("/categories")
	public String showCategoriesPage(Model model) {
		model.addAttribute("categories", categoryService.loadAllCategories());
		return view;
	}
}
