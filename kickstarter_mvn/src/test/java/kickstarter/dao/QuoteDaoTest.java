package kickstarter.dao;

import java.util.HashSet;
import java.util.List;

import kickstarter.entity.Category;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

//@ContextConfiguration(locations = { "classpath:spring-test-context.xml" })
public class QuoteDaoTest {//extends AbstractTransactionalJUnit4SpringContextTests {
//	@Autowired
//	private QuoteDao quoteDao;

//	public void setQuoteDao(QuoteDao quoteDao) {
//		this.quoteDao = quoteDao;
//	}

	@Test
	public void addNew() throws  IncorrectInputException, DataBaseException {
	/*	Category category = new Category();
		category.setName("TEST_CATEGORY");
		category.setProjects(new HashSet<Project>());
		categoryDao.addCategory(category);
		List<Category> categories = categoryDao.getCategories();*/
		System.out.println("11111111");
	}

}
