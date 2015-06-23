package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class AskQuestionView extends AbstractJspView {

	private static final String JSP_NAME = "/AskQuestion.jsp";
	private static final String[] INPUT_PARAMETERS = { "project", "category" };
	private static final String[] OUTPUT_ATTRIBUTES = { "project" };

	public AskQuestionView() {
		super(JSP_NAME, OUTPUT_ATTRIBUTES);
	}

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException {
		return getIntegerParameters(request, response, INPUT_PARAMETERS);
	}

}
