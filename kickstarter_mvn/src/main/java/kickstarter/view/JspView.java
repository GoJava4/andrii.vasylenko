package kickstarter.view;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.exception.IncorrectInputException;

public class JspView implements View {

	private String jspName;

	public JspView(String jspName) {
		this.jspName = jspName;
	}

	@Override
	public Map<String, String[]> getParameters(HttpServletRequest request, HttpServletResponse response)
			throws IncorrectInputException {
		checkInput(request, response);

		return request.getParameterMap();
	}

	@Override
	public void forward(HttpServletRequest request, HttpServletResponse response, Map<String, Object> data)
			throws IncorrectInputException, ServletException, IOException {
		checkInput(request, response);

		RequestDispatcher view = request.getRequestDispatcher(jspName);

		for (Map.Entry<String, Object> pair : data.entrySet()) {
			request.setAttribute(pair.getKey(), pair.getValue());
		}

		view.forward(request, response);
	}

	private void checkInput(HttpServletRequest request, HttpServletResponse response) throws IncorrectInputException {
		if (request == null || response == null) {
			throw new IncorrectInputException("request or response is null");
		}
	}
}
