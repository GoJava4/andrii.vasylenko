package ua.kiev.avp256.kickstarter_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.service.ProjectService;
import ua.kiev.avp256.kickstarter_server.service.QuestionService;

@Controller
@RequestMapping("/ask_question")
public class AskQuestionController {
	private ProjectService projectService;
	private QuestionService questionService;
	private String view;
	private String submitView;

	@RequestMapping(method = RequestMethod.GET)
	public String showAskQuestionPage(Model model, @RequestParam("project") int projectId) {
		model.addAttribute("project", projectService.loadProject(projectId));
		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitAskQuestionPage(Model model, @RequestParam("project") int projectId,
			@RequestParam("question") String question) {

		Question persistQuestion = questionService.persistQuestion(projectId, question);
		model.addAttribute("project", persistQuestion.getProject());
		model.addAttribute("question", persistQuestion);

		return submitView;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setView(String view) {
		this.view = view;
	}

	public void setSubmitView(String submitView) {
		this.submitView = submitView;
	}
}
