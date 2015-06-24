package kickstarter.control;

import static kickstarter.control.state.State.*;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import kickstarter.control.executor.Executor;

public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		Executor executor = (Executor) context.getBean("Executor");
		executor.execute(ASK_QUESTION, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		Executor executor = (Executor) context.getBean("Executor");
		executor.execute(ASK_QUESTION_SUBMIT, request, response);
	}
}
