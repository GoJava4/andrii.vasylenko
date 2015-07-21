package ua.kiev.avp256.kickstarter_server.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.controller.ProjectController;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;

public class ProjectControllerTest {
	@Mock
	private ProjectService projectService;
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

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionProjectsTest() {
		when(projectService.loadProjectsInCategory(anyInt())).thenThrow(DataNotFoundException.class);

		projectController.getProjects(0);
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionProjectsTest() {
		when(projectService.loadProjectsInCategory(anyInt())).thenThrow(RuntimeException.class);

		projectController.getProjects(0);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void dataNotFoundExceptionProjectTest() {
		when(projectService.loadProject(anyInt())).thenThrow(DataNotFoundException.class);

		projectController.getProject(0);
	}

	@Test(expected = Exception.class)
	@SuppressWarnings("unchecked")
	public void exceptionProjectTest() {
		when(projectService.loadProject(anyInt())).thenThrow(RuntimeException.class);

		projectController.getProject(0);
	}
}
