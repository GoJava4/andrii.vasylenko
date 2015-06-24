package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class DonateSubmitView extends AbstractJspView {

	private static final String JSP_NAME = "/DonateSubmit.jsp";
	private static final String[] INPUT_INTEGER_PARAMETERS = { "project", "category" };
	private static final String[] INPUT_STRING_PARAMETERS = { "paymentVariant", "amount" };
	private static final String[] OUTPUT_ATTRIBUTES = { "project", "amount" };

	public DonateSubmitView() {
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
