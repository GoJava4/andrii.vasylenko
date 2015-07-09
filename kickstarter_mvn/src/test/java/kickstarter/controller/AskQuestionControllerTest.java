package kickstarter.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import kickstarter.entity.Question;
import kickstarter.service.ProjectService;
import kickstarter.service.QuestionService;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test-context.xml")
public class AskQuestionControllerTest {
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
		assertEquals("AskQuestion", result);
	}

	@Test
	public void submitAskQuestionPageTest() {
		when(questionService.persistQuestion(anyInt(), anyString())).thenReturn(question);

		String result = askQuestionController.submitAskQuestionPage(model, 0, "");

		verify(model, times(1)).addAttribute("project", null);
		verify(model, times(1)).addAttribute("question", question);
		assertEquals("AskQuestionSubmit", result);
	}
}
