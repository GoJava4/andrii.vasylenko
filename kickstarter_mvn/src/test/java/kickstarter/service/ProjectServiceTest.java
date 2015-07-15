package kickstarter.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import kickstarter.dao.ProjectDao;
import kickstarter.entity.Project;
import kickstarter.exception.DataBaseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	public void loadProjectTest() throws DataBaseException {
		when(projectDao.load(anyInt())).thenReturn(project);

		Project result = projectService.loadProject(PROJECT_ID);

		assertEquals(project, result);
	}

	@Test
	public void loadProjectsInCategoryTest() throws DataBaseException {
		when(projectDao.loadProjectsInCategory(anyInt())).thenReturn(projects);

		List<Project> result = projectService.loadProjectsInCategory(CATEGORY_ID);

		assertEquals(projects, result);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnNull_whenDataBaseException() throws DataBaseException {
		when(projectDao.load(anyInt())).thenThrow(DataBaseException.class);
		when(projectDao.loadProjectsInCategory(anyInt())).thenThrow(DataBaseException.class);

		assertNull(projectService.loadProject(PROJECT_ID));
		assertNull(projectService.loadProjectsInCategory(CATEGORY_ID));
	}
}
