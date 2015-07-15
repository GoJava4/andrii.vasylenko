package kickstarter.entity;

import static org.junit.Assert.*;
import kickstarter.entity.Project;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class ProjectTest {
	private final static int DAYS_IN_TWO_YEARS = 365 * 2;
	private final static DateTime TEST_FINAL_DAY = new DateTime(2016, 1, 1, 0, 0, 0, DateTimeZone.forID("Europe/Kiev"));
	private final static DateTime TEST_CURRENT_DAY = new DateTime(2014, 1, 1, 0, 0, 0,
			DateTimeZone.forID("Europe/Kiev"));

	@Spy
	private Project project;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDaysLeftTest() {
		project.setFinalDate(TEST_FINAL_DAY);
		DateTimeUtils.setCurrentMillisFixed(TEST_CURRENT_DAY.getMillis());

		assertEquals(TEST_FINAL_DAY, project.getFinalDate());
		assertEquals(DAYS_IN_TWO_YEARS, project.getDaysLeft());

		DateTimeUtils.setCurrentMillisSystem();
	}
}
