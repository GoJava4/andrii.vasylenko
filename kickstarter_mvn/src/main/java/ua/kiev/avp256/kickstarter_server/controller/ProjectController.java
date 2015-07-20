package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

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
	private ProjectService projectService;

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public List<Project> getProjects(@PathVariable int categoryId) {
		try {
			return projectService.loadProjectsInCategory(categoryId);
		} catch (DataNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public Project getProject(@PathVariable int projectId) {
		try {
			return projectService.loadProject(projectId);
		} catch (DataNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
