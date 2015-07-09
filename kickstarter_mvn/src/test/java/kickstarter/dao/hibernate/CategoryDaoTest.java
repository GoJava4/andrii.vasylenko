package kickstarter.dao.hibernate;

import static org.junit.Assert.*;

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
	@Autowired
	private Category testCategory;

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException {
		categoryDao.persist(testCategory);

		int id = testCategory.getId();
		Category result = categoryDao.load(id);

		assertEquals("testName", result.getName());
	}

	@Test
	@Rollback(true)
	public void loadAllTest() throws DataBaseException {
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
