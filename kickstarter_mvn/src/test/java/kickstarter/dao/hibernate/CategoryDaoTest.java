package kickstarter.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kickstarter.dao.CategoryDao;
import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring-test-context.xml")
public class CategoryDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private CategoryDao categoryDao;

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException {
		Category category = new Category();
		category.setName("testName");

		categoryDao.persist(category);
		int id = category.getId();

		Category result = categoryDao.load(id);
		assertEquals("testName", result.getName());
	}

	@Test
	@Rollback(true)
	public void loadRandomTest() throws DataBaseException {
		List<Category> result = categoryDao.loadAll();
		assertNotNull(result);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		categoryDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		categoryDao.load(-1);
	}
}
