package ua.kiev.avp256.kickstarter_server.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.avp256.kickstarter_server.entity.Question;
import ua.kiev.avp256.kickstarter_server.exception.DataNotFoundException;
import ua.kiev.avp256.kickstarter_server.exception.InternalServerException;
import ua.kiev.avp256.kickstarter_server.service.QuestionService;

@RestController
@RequestMapping(value = "/v1/question", headers = "Accept=application/json")
public class QuestionController {
	private static final Logger LOG = LogManager.getLogger(QuestionController.class);

	private QuestionService questionService;

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
	public List<Question> getQuestionsInProject(@PathVariable int projectId) {
		LOG.entry(projectId);
		try {
			return LOG.exit(questionService.loadQuestionsInProject(projectId));
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.POST)
	public Question insertQuestionInProject(@PathVariable int projectId, @RequestBody String question) {
		LOG.entry(projectId, question);
		try {
			return LOG.exit(questionService.persistQuestion(projectId, question));
		} catch (DataNotFoundException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new InternalServerException("Unknown Internal Server Error");
		}
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
}
