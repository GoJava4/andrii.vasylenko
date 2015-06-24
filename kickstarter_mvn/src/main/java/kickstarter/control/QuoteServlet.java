package kickstarter.control;

import static kickstarter.control.state.State.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import kickstarter.control.executor.Executor;
import kickstarter.control.executor.ExecutorImpl;

public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		WebApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Executor executor = (Executor) context.getBean("executor");
		// Executor executor = ExecutorImpl.getInstance();
		executor.execute(QUOTE, request, response);
	}
}
