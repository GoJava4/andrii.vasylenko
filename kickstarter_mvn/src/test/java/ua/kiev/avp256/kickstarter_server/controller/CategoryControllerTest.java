package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import ua.kiev.avp256.kickstarter_server.controller.CategoryController;
import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.service.CategoryService;

public class CategoryControllerTest {
	@Mock
	private CategoryService categoryService;
	@Autowired
	@InjectMocks
	private CategoryController categoriesController;
	@Mock
	private List<Category> categories;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllCategoriesTest() {
		when(categoryService.loadAllCategories()).thenReturn(categories);

		List<Category> result = categoriesController.getAllCategories();

		assertEquals(categories, result);
	}
}
