package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Category;
import kickstarter.exception.DataBaseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:spring-test-context.xml" })
public class CategoryDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private CategoryDao categoryDao;

	public void setDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Test
	public void test1() throws DataBaseException, InterruptedException {
		// TODO: write Test for CategoryDao
		// List<Category> categories = categoryDao.getCategories();
	}

}
