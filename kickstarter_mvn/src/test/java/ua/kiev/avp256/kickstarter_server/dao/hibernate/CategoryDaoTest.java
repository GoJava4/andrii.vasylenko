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
import ua.kiev.avp256.kickstarter_server.exception.DataBaseException;

@ContextConfiguration("classpath:hibernate-test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class CategoryDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Category fakeCategory;

	@Test
	public void loadTest() throws DataBaseException {
		Category result = categoryDao.load(1);

		assertEquals("Sport", result.getName());
	}

	@Test
	public void persistTest() throws DataBaseException {
		categoryDao.persist(fakeCategory);

		int id = fakeCategory.getId();
		Category result = categoryDao.load(id);

		assertEquals("testName", result.getName());
	}

	@Test
	public void loadAllTest() throws DataBaseException {
		List<Category> result = categoryDao.loadAll();
		assertNotNull(result);
	}

	@Test(expected = DataBaseException.class)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		categoryDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		categoryDao.load(-1);
	}
}
