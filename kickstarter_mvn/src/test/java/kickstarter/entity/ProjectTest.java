package kickstarter.entity;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private Project fakeProject;

	@Test
	public void getDaysLeftTest() throws ParseException {
		assertEquals(expectedDaysLeft(), fakeProject.getDaysLeft());
	}

	private int expectedDaysLeft() throws ParseException {
		Date finalDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
		long diff = finalDate.getTime() - System.currentTimeMillis();
		return (int) (diff / 1000 / 60 / 60 / 24);
	}
}
