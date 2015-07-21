package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.controller.QuestionController;
import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.QuestionService;

public class QuestionControllerTest {
	@Mock
	private QuestionService questionService;
	@InjectMocks
	private QuestionController questionController;
	@Mock
	private Question question;
	@Mock
	private List<Question> questions;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getQuestionsInProjectTest() {
		when(questionService.loadQuestionsInProject(anyInt())).thenReturn(questions);

		List<Question> result = questionController.getQuestionsInProject(0);

		assertEquals(questions, result);
	}

	@Test
	public void insertQuestionInProjectTest() {
		when(questionService.persistQuestion(anyInt(), anyString())).thenReturn(question);

		Question result = questionController.insertQuestionInProject(0, "question");

		verify(questionService, times(1)).persistQuestion(0, "question");
		assertEquals(question, result);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionGetTest() {
		when(questionService.loadQuestionsInProject(anyInt())).thenThrow(DataNotFoundException.class);

		questionController.getQuestionsInProject(0);
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionGetTest() {
		when(questionService.loadQuestionsInProject(anyInt())).thenThrow(RuntimeException.class);

		questionController.getQuestionsInProject(0);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionInsertTest() {
		when(questionService.persistQuestion(anyInt(), anyString())).thenThrow(DataNotFoundException.class);

		questionController.insertQuestionInProject(0, "question");
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionInsertTest() {
		when(questionService.persistQuestion(anyInt(), anyString())).thenThrow(RuntimeException.class);

		questionController.insertQuestionInProject(0, "question");
	}
}
