package kickstarter.control;

import static kickstarter.control.state.State.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.control.executor.Executor;
import kickstarter.control.state.State;

import org.springframework.web.HttpRequestHandler;

public class DonateServlet implements HttpRequestHandler {
	private Executor executor;

	public DonateServlet(Executor executor) {
		this.executor = executor;
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		State state = getState(request.getMethod());
		executor.execute(state, request, response);
	}

	private State getState(String method) {
		if ("GET".equalsIgnoreCase(method)) {
			return DONATE;
		} else if ("POST".equalsIgnoreCase(method)) {
			return DONATE_SUBMIT;
		}
		return null;
	}
}
