package kickstarter.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import kickstarter.dao.ProjectDao;
import kickstarter.dao.QuestionDao;
import kickstarter.entity.Project;
import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test-context.xml")
public class QuestionServiceTest {
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
	public void persistQuestionTest() throws DataBaseException {
		when(projectDao.load(anyInt())).thenReturn(project);

		Question result = questionService.persistQuestion(0, "testQuestion");

		verify(questionDao, times(1)).persist(result);
		assertEquals(project, result.getProject());
		assertEquals("testQuestion", result.getQuestion());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnNull_whenDataBaseException() throws DataBaseException {
		when(projectDao.load(anyInt())).thenThrow(DataBaseException.class);

		assertNull(questionService.persistQuestion(0, "testQuestion"));
	}
}
