package kickstarter.control;

import static kickstarter.control.state.State.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.control.executor.Executor;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class DonateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		Executor executor = (Executor) context.getBean("Executor");
		executor.execute(DONATE, request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		/*WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		Executor executor = (Executor) context.getBean("Executor");
		executor.execute(ASK_QUESTION_SUBMIT, request, response);
		
		System.out.println(request.getParameter("id"));*/
	}
}
