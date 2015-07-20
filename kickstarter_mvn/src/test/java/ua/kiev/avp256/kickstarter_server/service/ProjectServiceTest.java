package ua.kiev.avp256.kickstarter_server.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kiev.avp256.kickstarter_server.dao.ProjectDao;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;

public class ProjectServiceTest {
	private static final int PROJECT_ID = 1;
	private static final int CATEGORY_ID = 1;

	@Mock
	private Project project;
	@Mock
	private List<Project> projects;
	@Mock
	private ProjectDao projectDao;
	@InjectMocks
	private ProjectService projectService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loadProjectTest() {
		when(projectDao.load(anyInt())).thenReturn(project);

		Project result = projectService.loadProject(PROJECT_ID);

		assertEquals(project, result);
	}

	@Test
	public void loadProjectsInCategoryTest() {
		when(projectDao.loadProjectsInCategory(anyInt())).thenReturn(projects);

		List<Project> result = projectService.loadProjectsInCategory(CATEGORY_ID);

		assertEquals(projects, result);
	}

	@Test(expected = DataNotFoundException.class)
	@SuppressWarnings("unchecked")
	public void throwExceptionTest() {
		when(projectDao.load(anyInt())).thenThrow(DataNotFoundException.class);

		projectService.loadProject(PROJECT_ID);
	}
}
