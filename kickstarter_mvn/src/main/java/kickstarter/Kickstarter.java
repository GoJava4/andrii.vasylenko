package kickstarter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.model.Model;
import kickstarter.view.View;

import org.apache.log4j.Logger;
import org.springframework.web.HttpRequestHandler;

public class Kickstarter implements HttpRequestHandler {

	private View view;
	private Model model;

	public Kickstarter(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			execute(request, response);
		} catch (Exception e) {
			showError(e);
		}
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String[]> parameters = view.getParameters(request, response);
		Map<String, Object> data = model.getData(parameters);

		view.forward(request, response, data);
	}

	private void showError(Exception e) {
		Logger logger = Logger.getLogger(Kickstarter.class);
		logger.error(e.getStackTrace(), e);
		// TODO: show page with error for user
	}
}
