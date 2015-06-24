package kickstarter.view.factory;

import static kickstarter.control.state.State.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import kickstarter.control.state.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.view.View;

public class ViewFactoryImpl implements ViewFactory {
	private static final Map<State, String> BEANS = new HashMap<>();

	static {
		BEANS.put(QUOTE, "QuoteView");
		BEANS.put(CATEGORIES, "CategoriesView");
		BEANS.put(PROJECTS, "ProjectsView");
		BEANS.put(PROJECT, "ProjectView");
		BEANS.put(ASK_QUESTION, "AskQuestionView");
		BEANS.put(ASK_QUESTION_SUBMIT, "AskQuestionSubmitView");
	}

	@Override
	public View getView(State state) throws IncorrectInputException {
		if (state == null || !BEANS.containsKey(state)) {
			throw new IncorrectInputException("state is null");
		}

		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		View view = (View) context.getBean(BEANS.get(state));

		return view;
	}
}
