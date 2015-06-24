package kickstarter.model.factory;

import static kickstarter.control.state.State.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import kickstarter.control.state.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.Model;
import kickstarter.model.dao.DAO;
import kickstarter.model.dao.DAOImpl;
import kickstarter.model.dao.connection.ConnectionPoolImpl;

public class ModelFactoryImpl implements ModelFactory {
	private static final Map<State, String> BEANS = new HashMap<>();

	private DAO dao;

	static {
		BEANS.put(QUOTE, "QuoteModel");
		BEANS.put(CATEGORIES, "CategoriesModel");
		BEANS.put(PROJECTS, "ProjectsModel");
		BEANS.put(PROJECT, "ProjectModel");
		BEANS.put(ASK_QUESTION, "AskQuestionModel");
		BEANS.put(ASK_QUESTION_SUBMIT, "AskQuestionSubmitModel");
	}

	public ModelFactoryImpl() {
		try {
			this.dao = new DAOImpl(ConnectionPoolImpl.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Model getModel(State state) throws IncorrectInputException {
		if (state == null || !BEANS.containsKey(state)) {
			throw new IncorrectInputException("state is null");
		}

		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		Model model = (Model) context.getBean(BEANS.get(state));

		model.init(dao);

		return model;
	}
}
