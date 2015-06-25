package kickstarter.control;

import static kickstarter.control.state.State.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import kickstarter.control.executor.Executor;

public class CategoriesServlet implements HttpRequestHandler {
	private Executor executor;

	public CategoriesServlet(Executor executor) {
		this.executor = executor;
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		executor.execute(CATEGORIES, request, response);
	}
}
