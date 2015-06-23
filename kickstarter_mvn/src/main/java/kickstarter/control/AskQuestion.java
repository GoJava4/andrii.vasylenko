package kickstarter.control;

import static kickstarter.control.state.State.*;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.control.executor.Executor;
import kickstarter.control.executor.ExecutorImpl;

public class AskQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		Executor executor = ExecutorImpl.getInstance();
		executor.execute(ASK_QUESTION, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Executor executor = ExecutorImpl.getInstance();
		executor.execute(ASK_QUESTION_SUBMIT, request, response);
	}
}
