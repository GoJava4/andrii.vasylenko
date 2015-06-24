package kickstarter.view.factory;

import static kickstarter.control.state.State.*;

import java.util.HashMap;
import java.util.Map;

import kickstarter.control.state.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.view.AskQuestionSubmitView;
import kickstarter.view.AskQuestionView;
import kickstarter.view.CategoriesView;
import kickstarter.view.ProjectView;
import kickstarter.view.ProjectsView;
import kickstarter.view.QuoteView;
import kickstarter.view.View;

public class ViewFactoryImpl implements ViewFactory {
	private static final Map<State, View> states = new HashMap<>();

	static {
		states.put(QUOTE, new QuoteView());
		states.put(CATEGORIES, new CategoriesView());
		states.put(PROJECTS, new ProjectsView());
		states.put(PROJECT, new ProjectView());
		states.put(ASK_QUESTION, new AskQuestionView());
		states.put(ASK_QUESTION_SUBMIT, new AskQuestionSubmitView());
	}

	@Override
	public View getView(State state) throws IncorrectInputException {
		if (state == null || !states.containsKey(state)) {
			throw new IncorrectInputException("state is null");
		}

		return states.get(state);
	}
}
