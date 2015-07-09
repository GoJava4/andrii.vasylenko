package kickstarter.entity;

import static org.junit.Assert.*;

import java.util.Date;

import kickstarter.entity.Project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test-context.xml")
public class ProjectTest {
	@Autowired
	private Project testProject;
	@Autowired
	Date testFinalDate;

	@Test
	public void shouldGetTheSameProject_whenNewProject() {
		assertEquals(expectedDaysLeft(), testProject.getDaysLeft());
	}

	private int expectedDaysLeft() {
		long diff = testFinalDate.getTime() - System.currentTimeMillis();
		return (int) (diff / 1000 / 60 / 60 / 24);
	}
}
