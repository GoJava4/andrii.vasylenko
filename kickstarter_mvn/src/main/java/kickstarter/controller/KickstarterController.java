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
