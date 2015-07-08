package kickstarter.controller;

import kickstarter.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
	private ProjectService projectService;
	private String view;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setView(String view) {
		this.view = view;
	}

	@RequestMapping("/project")
	public String showProjectPage(Model model, @RequestParam("project") int projectId) {
		model.addAttribute("project", projectService.loadProject(projectId));
		return view;
	}
}
