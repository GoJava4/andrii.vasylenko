package kickstarter.control;

import static kickstarter.control.state.State.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import kickstarter.control.executor.Executor;
import kickstarter.control.state.State;

public class AskQuestionServlet implements HttpRequestHandler {
	private Executor executor;

	public AskQuestionServlet(Executor executor) {
		this.executor = executor;
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		State state = getState(request.getMethod());
		executor.execute(state, request, response);
	}

	private State getState(String method) {
		if ("GET".equalsIgnoreCase(method)) {
			return ASK_QUESTION;
		} else if ("POST".equalsIgnoreCase(method)) {
			return ASK_QUESTION_SUBMIT;
		}
		return null;
	}
}
