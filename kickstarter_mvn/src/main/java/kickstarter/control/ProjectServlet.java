package kickstarter.control;

import static kickstarter.control.state.State.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import kickstarter.control.executor.Executor;

public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		Executor executor = (Executor) context.getBean("executor");
		executor.execute(PROJECT, request, response);
	}
}
