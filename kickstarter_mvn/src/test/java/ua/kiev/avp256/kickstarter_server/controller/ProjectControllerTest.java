package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import ua.kiev.avp256.kickstarter_server.controller.ProjectController;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;

public class ProjectControllerTest {
	@Mock
	private ProjectService projectService;
	@Mock
	private Model model;
	@Autowired
	@InjectMocks
	private ProjectController projectController;
	@Mock
	private Project project;
	@Mock
	private List<Project> projects;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getProjectsTest() {
		when(projectService.loadProjectsInCategory(anyInt())).thenReturn(projects);

		List<Project> result = projectController.getProjects(0);

		assertEquals(projects, result);
	}

	@Test
	public void getProjectTest() {
		when(projectService.loadProject(anyInt())).thenReturn(project);

		Project result = projectController.getProject(0);

		assertEquals(project, result);
	}
}
