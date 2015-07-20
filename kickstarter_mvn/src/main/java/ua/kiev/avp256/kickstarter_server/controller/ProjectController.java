package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;

@RestController
@RequestMapping(value = "/v1/project", headers = "Accept=application/json")
public class ProjectController {
	private ProjectService projectService;

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public List<Project> getProjects(@PathVariable int categoryId) {
		return projectService.loadProjectsInCategory(categoryId);
	}

	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public Project getProject(@PathVariable int projectId) {
		return projectService.loadProject(projectId);
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
