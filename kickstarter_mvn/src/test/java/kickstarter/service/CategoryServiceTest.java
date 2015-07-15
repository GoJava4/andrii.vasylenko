package kickstarter.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import kickstarter.dao.CategoryDao;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	public void loadAllCategoriesTest() throws DataBaseException {
		when(categoryDao.loadAll()).thenReturn(categories);

		List<Category> result = categoryService.loadAllCategories();

		assertEquals(categories, result);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnNull_whenDataBaseException() throws DataBaseException {
		when(categoryDao.loadAll()).thenThrow(DataBaseException.class);

		List<Category> result = categoryService.loadAllCategories();

		assertNull(result);
	}
}
