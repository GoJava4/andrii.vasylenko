package kickstarter.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import kickstarter.service.ProjectService;

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
public class ProjectControllerTest {
	@Mock
	private ProjectService projectService;
	@Mock
	private Model model;
	@Autowired
	@InjectMocks
	private ProjectController projectController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showProjectPageTest() {
		when(projectService.loadProject(anyInt())).thenReturn(null);

		String result = projectController.showProjectPage(model, 0);

		verify(model, times(1)).addAttribute("project", null);
		assertEquals("Project", result);
	}
}
