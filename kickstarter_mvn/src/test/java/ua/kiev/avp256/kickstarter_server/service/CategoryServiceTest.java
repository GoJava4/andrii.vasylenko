package ua.kiev.avp256.kickstarter_server.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.dao.CategoryDao;
import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.CategoryService;

public class CategoryServiceTest {
	@Mock
	List<Category> categories;
	@Mock
	private CategoryDao categoryDao;
	@InjectMocks
	private CategoryService categoryService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loadAllCategoriesTest() {
		when(categoryDao.loadAll()).thenReturn(categories);

		List<Category> result = categoryService.loadAllCategories();

		assertEquals(categories, result);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void throwExceptionTest() {
		when(categoryDao.loadAll()).thenThrow(DataNotFoundException.class);

		categoryService.loadAllCategories();
	}
}
