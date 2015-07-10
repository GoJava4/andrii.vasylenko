package kickstarter.dao.hibernate;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kickstarter.dao.ProjectDao;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring-test-context.xml")
public class ProjectDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private Project fakeProject;

	@Test
	@Rollback(true)
	public void loadTest() throws DataBaseException, ParseException {
		Project result = projectDao.load(1);

		assertEquals(1, result.getCategory().getId());
		assertEquals("Sport", result.getCategory().getName());
		assertEquals("velo parking", result.getName());
		assertEquals("velo parking in Kiev", result.getDescription());
		assertEquals(10000, result.getTotalAmount());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2015-09-30"), result.getFinalDate());
		assertEquals("History1", result.getHistory());
		assertEquals("www.project1.com", result.getLink());
		assertEquals(500, result.getCollectAmount());
		assertEquals(1, result.getPayments().size());
		assertEquals(3, result.getPaymentVariants().size());
		assertEquals(1, result.getQuestions().size());
	}

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException, ParseException {
		projectDao.persist(fakeProject);

		int id = fakeProject.getId();
		Project result = projectDao.load(id);

		assertEquals("testName", result.getName());
		assertEquals(1, result.getCategory().getId());
		assertEquals("testDescription", result.getDescription());
		assertEquals(10000, result.getTotalAmount());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"), result.getFinalDate());
		assertEquals("testHistory", result.getHistory());
		assertEquals("testLink", result.getLink());
	}

	@Test
	@Rollback(true)
	public void loadProjectsInCategoryTest() throws DataBaseException {
		List<Project> result = projectDao.loadProjectsInCategory(1);
		assertEquals(2, result.size());
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenPersistNull() throws DataBaseException {
		projectDao.persist(null);
	}

	@Test(expected = DataBaseException.class)
	@Rollback(true)
	public void shouldThrowException_whenIncorrectId() throws DataBaseException {
		projectDao.load(-1);
	}
}
