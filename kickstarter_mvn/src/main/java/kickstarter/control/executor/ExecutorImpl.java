package kickstarter.control.executor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kickstarter.control.state.State;
import kickstarter.model.Model;
import kickstarter.model.factory.ModelFactory;
import kickstarter.view.View;
import kickstarter.view.factory.ViewFactory;

public class ExecutorImpl implements Executor {
	private ModelFactory modelFactory;
	private ViewFactory viewFactory;

	public ExecutorImpl(ModelFactory modelFactory, ViewFactory viewFactory) {
		this.modelFactory = modelFactory;
		this.viewFactory = viewFactory;
	}

	@Override
	public void execute(State state, HttpServletRequest request, HttpServletResponse response) {
		try {
			start(state, request, response);
		} catch (Exception e) {
			showError(e);
		}
	}

	private void start(State state, HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = viewFactory.getView(state);
		Model model = modelFactory.getModel(state);

		Map<String, Object> parameters = view.getParameters(request, response);
		Map<String, Object> data = model.getData(parameters);

		view.forward(request, response, data);
	}

	private void showError(Exception e) {
		Logger logger = Logger.getLogger(ExecutorImpl.class);
		logger.error(e.getStackTrace(), e);
		// TODO: show page with error for user
	}
}
