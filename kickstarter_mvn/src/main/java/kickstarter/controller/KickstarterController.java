package kickstarter.controller;

import kickstarter.dao.ProjectDao;
import kickstarter.dao.QuestionDao;
import kickstarter.entity.Project;
import kickstarter.entity.Question;
import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KickstarterController {
	private ProjectDao projectDao;
	private QuestionDao questionDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@RequestMapping("/projects")
	public String showProjectsPage(Model model, @RequestParam("category") int categoryId) throws DataBaseException {
		model.addAttribute("projects", projectDao.loadProjectsInCategory(categoryId));
		return "Projects";
	}

	@RequestMapping("/project")
	public String showProjectPage(Model model, @RequestParam("category") int categoryId,
			@RequestParam("project") int projectId) throws DataBaseException {
		model.addAttribute("project", projectDao.load(projectId));
		return "Project";
	}

	@RequestMapping("/ask_question")
	public String showAskQuestionPage(Model model, @RequestParam("category") int categoryId,
			@RequestParam("project") int projectId) throws DataBaseException {
		model.addAttribute("project", projectDao.load(projectId));
		return "AskQuestion";
	}

	@RequestMapping(value = "/ask_question_submit", method = RequestMethod.POST)
	public String submitAskQuestionPage(Model model, @RequestParam("category") int categoryId,
			@RequestParam("project") int projectId, @RequestParam("question") String question)
			throws DataBaseException, IncorrectInputException {
		Project project = projectDao.load(projectId);
		Question entity = new Question();
		entity.setProject(project);
		entity.setQuestion(question);
		questionDao.persist(entity);

		model.addAttribute("project", project);
		model.addAttribute("question", question);

		return "AskQuestionSubmit";
	}

	@RequestMapping("/donate")
	public String showDonatePage(Model model, @RequestParam("category") int categoryId,
			@RequestParam("project") int projectId) throws DataBaseException {
		model.addAttribute("project", projectDao.load(projectId));
		return "Donate";
	}

	/*
	 * @RequestMapping(value = "/donate_submit", method = RequestMethod.POST)
	 * public String submitDonatePage(Model model, @RequestParam("category") int
	 * categoryId) throws DataBaseException { // model.addAttribute("projects",
	 * projectDao.getProjects(categoryId)); return "DonateSubmit"; }
	 */
}
