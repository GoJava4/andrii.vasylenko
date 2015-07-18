package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import ua.kiev.avp256.kickstarter_server.controller.CategoriesController;
import ua.kiev.avp256.kickstarter_server.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mvc-context.xml")
public class CategoriesControllerTest {
	private static final String VIEW = "Categories";

	@Mock
	private CategoryService categoryService;
	@Mock
	private Model model;
	@Autowired
	@InjectMocks
	private CategoriesController categoriesController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showCategoriesPageTest() {
		when(categoryService.loadAllCategories()).thenReturn(null);

		String result = categoriesController.showCategoriesPage(model);

		verify(model, times(1)).addAttribute("categories", null);
		assertEquals(VIEW, result);
	}
}
