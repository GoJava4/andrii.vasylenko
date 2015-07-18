package ua.kiev.avp256.kickstarter_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kiev.avp256.kickstarter_server.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectsController {
	private ProjectService projectService;
	private String view;

	@RequestMapping(method = RequestMethod.GET)
	public String showProjectsPage(Model model, @RequestParam("category") int categoryId) {
		model.addAttribute("projects", projectService.loadProjectsInCategory(categoryId));
		return view;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setView(String view) {
		this.view = view;
	}
}
