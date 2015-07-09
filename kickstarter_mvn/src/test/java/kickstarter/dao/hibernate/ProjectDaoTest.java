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
	private Project testProject;
	@Autowired
	SimpleDateFormat dateFormat;

	@Test
	@Rollback(true)
	public void persistTest() throws DataBaseException, ParseException {
		projectDao.persist(testProject);

		int id = testProject.getId();
		Project result = projectDao.load(id);

		assertEquals("testName", result.getName());
		assertEquals(1, result.getCategory().getId());
		assertEquals("testDescription", result.getDescription());
		assertEquals(10000, result.getTotalAmount());
		assertEquals(dateFormat.parse("2020-01-01"), result.getFinalDate());
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
