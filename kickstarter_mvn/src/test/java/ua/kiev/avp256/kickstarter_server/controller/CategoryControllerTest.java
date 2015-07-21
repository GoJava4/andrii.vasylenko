package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.controller.CategoryController;
import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.CategoryService;

public class CategoryControllerTest {
	@Mock
	private CategoryService categoryService;
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

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionTest() {
		when(categoryService.loadAllCategories()).thenThrow(DataNotFoundException.class);

		categoriesController.getAllCategories();
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionTest() {
		when(categoryService.loadAllCategories()).thenThrow(RuntimeException.class);

		categoriesController.getAllCategories();
	}
}
