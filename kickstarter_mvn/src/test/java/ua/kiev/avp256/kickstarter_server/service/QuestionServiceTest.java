package ua.kiev.avp256.kickstarter_server.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.dao.QuestionDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.QuestionService;

public class QuestionServiceTest {
	private static final int PROJECT_ID = 1;
	private static final String QUESTION = "testQuestion";

	@Mock
	private Project project;
	@Mock
	private ProjectDao projectDao;
	@Mock
	private QuestionDao questionDao;
	@InjectMocks
	private QuestionService questionService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void persistQuestionTest() {
		when(projectDao.load(anyInt())).thenReturn(project);

		Question result = questionService.persistQuestion(PROJECT_ID, QUESTION);

		verify(questionDao, times(1)).persist(result);
		assertEquals(project, result.getProject());
		assertEquals(QUESTION, result.getQuestion());
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void throwExceptionTest() {
		when(projectDao.load(anyInt())).thenThrow(DataNotFoundException.class);

		questionService.persistQuestion(PROJECT_ID, QUESTION);
	}
}
