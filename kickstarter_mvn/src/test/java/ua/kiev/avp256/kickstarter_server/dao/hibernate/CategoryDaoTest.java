package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.kiev.avp256.kickstarter_server.dao.CategoryDao;
import ua.kiev.avp256.kickstarter_server.entity.Category;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;

@ContextConfiguration("classpath:hibernate-test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class CategoryDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Category fakeCategory;

	@Test
	public void loadTest() {
		Category result = categoryDao.load(1);

		assertEquals("Sport", result.getName());
	}

	@Test
	public void persistTest() {
		categoryDao.persist(fakeCategory);

		int id = fakeCategory.getId();
		Category result = categoryDao.load(id);

		assertEquals("testName", result.getName());
	}

	@Test
	public void loadAllTest() {
		List<Category> result = categoryDao.loadAll();
		assertNotNull(result);
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenPersistNull() {
		categoryDao.persist(null);
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenIncorrectId() {
		categoryDao.load(-1);
	}
}
