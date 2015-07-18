package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import ua.kiev.avp256.kickstarter_server.controller.AskQuestionController;
import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;
import ua.kiev.avp256.kickstarter_server.service.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mvc-context.xml")
public class AskQuestionControllerTest {
	private static final String VIEW = "AskQuestion";
	private static final String SUBMIT_VIEW = "AskQuestionSubmit";

	@Mock
	private ProjectService projectService;
	@Mock
	private QuestionService questionService;
	@Mock
	private Model model;
	@Mock
	private Question question;
	@Autowired
	@InjectMocks
	private AskQuestionController askQuestionController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showAskQuestionPageTest() {
		when(projectService.loadProject(anyInt())).thenReturn(null);

		String result = askQuestionController.showAskQuestionPage(model, 0);

		verify(model, times(1)).addAttribute("project", null);
		assertEquals(VIEW, result);
	}

	@Test
	public void submitAskQuestionPageTest() {
		when(questionService.persistQuestion(anyInt(), anyString())).thenReturn(question);

		String result = askQuestionController.submitAskQuestionPage(model, 0, "");

		verify(model, times(1)).addAttribute("project", null);
		verify(model, times(1)).addAttribute("question", question);
		assertEquals(SUBMIT_VIEW, result);
	}
}
