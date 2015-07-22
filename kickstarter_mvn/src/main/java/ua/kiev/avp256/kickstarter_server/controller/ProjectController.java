package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.exception.InternalServerException;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;

@RestController
@RequestMapping(value = "/v1/project", headers = "Accept=application/json")
public class ProjectController {
	private static final Logger LOG = LogManager.getLogger(ProjectController.class);

	private ProjectService projectService;

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public List<Project> getProjects(@PathVariable int categoryId) {
		LOG.entry(categoryId);
		try {
			return LOG.exit(projectService.loadProjectsInCategory(categoryId));
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public Project getProject(@PathVariable int projectId) {
		LOG.entry(projectId);
		try {
			return LOG.exit(projectService.loadProject(projectId));
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
