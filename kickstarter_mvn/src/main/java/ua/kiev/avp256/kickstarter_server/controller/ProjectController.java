package ua.kiev.avp256.kickstarter_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kiev.avp256.kickstarter_server.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private ProjectService projectService;
	private String view;

	@RequestMapping(method = RequestMethod.GET)
	public String showProjectPage(Model model, @RequestParam("project") int projectId) {
		model.addAttribute("project", projectService.loadProject(projectId));
		return view;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setView(String view) {
		this.view = view;
	}
}
