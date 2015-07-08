package kickstarter.controller;

import kickstarter.exception.DataBaseException;
import kickstarter.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectsController {
	private ProjectService projectService;
	private String view;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setView(String view) {
		this.view = view;
	}

	@RequestMapping("/projects")
	public String showProjectsPage(Model model, @RequestParam("category") int categoryId) throws DataBaseException {
		model.addAttribute("projects", projectService.loadProjectsInCategory(categoryId));
		return view;
	}
}
