package ua.kiev.avp256.kickstarter_server.entity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import ua.kiev.avp256.kickstarter_server.entity.Project;

public class ProjectTest {
	private final static int DAYS_IN_TWO_YEARS = 365 * 2;
	private final static DateTimeZone TIME_ZONE = DateTimeZone.forID("Europe/Kiev");
	private final static DateTime TEST_FINAL_DAY = new DateTime(2016, 1, 1, 0, 0, 0, TIME_ZONE);
	private final static DateTime TEST_CURRENT_DAY = new DateTime(2014, 1, 1, 0, 0, 0, TIME_ZONE);

	@Spy
	private Project project;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDaysLeftTest() {
		DateTimeUtils.setCurrentMillisFixed(TEST_CURRENT_DAY.getMillis());

		when(project.getFinalDate()).thenReturn(TEST_FINAL_DAY);

		assertEquals(DAYS_IN_TWO_YEARS, project.getDaysLeft());

		DateTimeUtils.setCurrentMillisSystem();
	}
}
