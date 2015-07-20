package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;

@ContextConfiguration("classpath:hibernate-test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class ProjectDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private Project fakeProject;

	@Test
	public void loadTest() {
		Project result = projectDao.load(1);

		assertEquals(1, result.getCategory().getId());
		assertEquals("Sport", result.getCategory().getName());
		assertEquals("velo parking", result.getName());
		assertEquals("velo parking in Kiev", result.getDescription());
		assertEquals(10000, result.getTotalAmount());
		assertEquals(new DateTime(2015, 9, 30, 0, 0, 0, DateTimeZone.forID("Europe/Kiev")), result.getFinalDate());
		assertEquals("History1", result.getHistory());
		assertEquals("www.project1.com", result.getLink());
		assertEquals(new Integer(500), result.getCollectAmount());
		assertEquals(1, result.getPayments().size());
		assertEquals(3, result.getPaymentVariants().size());
		assertEquals(1, result.getQuestions().size());
	}

	@Test
	public void persistTest() {
		projectDao.persist(fakeProject);

		int id = fakeProject.getId();
		Project result = projectDao.load(id);

		assertEquals("testName", result.getName());
		assertEquals(1, result.getCategory().getId());
		assertEquals("testDescription", result.getDescription());
		assertEquals(10000, result.getTotalAmount());
		assertEquals(new DateTime(2020, 1, 1, 0, 0, 0, DateTimeZone.forID("Europe/Kiev")), result.getFinalDate());
		assertEquals("testHistory", result.getHistory());
		assertEquals("testLink", result.getLink());
	}

	@Test
	public void loadProjectsInCategoryTest() {
		List<Project> result = projectDao.loadProjectsInCategory(1);
		assertEquals(2, result.size());
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenPersistNull() {
		projectDao.persist(null);
	}

	@Test(expected = DataNotFoundException.class)
	public void shouldThrowException_whenIncorrectId() {
		projectDao.load(-1);
	}
}
