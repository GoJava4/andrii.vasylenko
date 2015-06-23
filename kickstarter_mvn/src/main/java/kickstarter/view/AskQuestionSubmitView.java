package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class AskQuestionSubmitView extends AbstractJspView {

	private static final String JSP_NAME = "/AskQuestionSubmit.jsp";
	private static final String[] INPUT_INTEGER_PARAMETERS = { "project", "category" };
	private static final String[] INPUT_STRING_PARAMETERS = { "question" };
	private static final String[] OUTPUT_ATTRIBUTES = { "project", "question" };

	public AskQuestionSubmitView() {
		super(JSP_NAME, OUTPUT_ATTRIBUTES);
	}

	@Override
	public Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException {
		Map<String, Object> result = getIntegerParameters(request, response, INPUT_INTEGER_PARAMETERS);
		result.putAll(getStringParameters(request, response, INPUT_STRING_PARAMETERS));
		return result;
	}

}
