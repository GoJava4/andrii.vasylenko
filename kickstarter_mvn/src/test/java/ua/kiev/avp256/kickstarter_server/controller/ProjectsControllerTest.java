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

import ua.kiev.avp256.kickstarter_server.controller.ProjectsController;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mvc-context.xml")
public class ProjectsControllerTest {
	private static final String VIEW = "Projects";

	@Mock
	private ProjectService projectService;
	@Mock
	private Model model;
	@Autowired
	@InjectMocks
	private ProjectsController projectsController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showProjectsPageTest() {
		when(projectService.loadProjectsInCategory(anyInt())).thenReturn(null);

		String result = projectsController.showProjectsPage(model, 0);

		verify(model, times(1)).addAttribute("projects", null);
		assertEquals(VIEW, result);
	}
}
