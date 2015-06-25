package kickstarter.dao;

import java.sql.SQLException;
import java.util.List;

import kickstarter.dao.sub.CategoriesDAO;
import kickstarter.dao.sub.PaymentsDAO;
import kickstarter.dao.sub.ProjectsDAO;
import kickstarter.dao.sub.QuestionsDAO;
import kickstarter.dao.sub.QuotesDAO;
import kickstarter.entity.Category;
import kickstarter.entity.PaymentVariant;
import kickstarter.entity.Project;
import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class DAOImpl implements DAO {
	private QuotesDAO quotes;
	private CategoriesDAO categories;
	private ProjectsDAO projects;
	private QuestionsDAO questions;
	private PaymentsDAO payments;

	public DAOImpl(QuotesDAO quotes, CategoriesDAO categories, ProjectsDAO projects, QuestionsDAO questions,
			PaymentsDAO payments) {
		this.quotes = quotes;
		this.categories = categories;
		this.projects = projects;
		this.questions = questions;
		this.payments = payments;
	}

	@Override
	public void initData() throws DataBaseException, SQLException {
		createTables();
		setDefaultsData();
	}

	@Override
	public void addQuote(String quote) throws DataBaseException, SQLException {
		quotes.addQuote(quote);
	}

	@Override
	public Quote getRandomQuote() throws DataBaseException, SQLException {
		return quotes.getRandomQuote();
	}

	@Override
	public void createTableQuotes() throws DataBaseException, SQLException {
		quotes.createTableQuotes();
	}

	@Override
	public void addCategory(String name) throws DataBaseException, SQLException {
		categories.addCategory(name);
	}

	@Override
	public List<Category> getCategories() throws DataBaseException, SQLException {
		return categories.getCategories();
	}

	@Override
	public Category getCategory(int id) throws DataBaseException, SQLException {
		return categories.getCategory(id);
	}

	@Override
	public void createTableCategories() throws DataBaseException, SQLException {
		categories.createTableCategories();
	}

	@Override
	public void addProject(int categoryId, String name, String description, int totalAmount, int daysLeft,
			String history, String link) throws DataBaseException, SQLException {
		projects.addProject(categoryId, name, description, totalAmount, daysLeft, history, link);
	}

	@Override
	public List<Project> getProjects(int categoryId) throws DataBaseException, SQLException {
		return projects.getProjects(categoryId);
	}

	@Override
	public Project getProject(int id, int categoryId) throws DataBaseException, SQLException {
		return projects.getProject(id, categoryId);
	}

	@Override
	public void createTableProjects() throws DataBaseException, SQLException {
		projects.createTableProjects();
	}

	@Override
	public void addQuestion(int projectId, String question) throws DataBaseException, SQLException {
		questions.addQuestion(projectId, question);
	}

	@Override
	public void createTableQuestions() throws DataBaseException, SQLException {
		questions.createTableQuestions();
	}

	@Override
	public void addPaymentVariant(int projectId, int amount, String description) throws DataBaseException, SQLException {
		payments.addPaymentVariant(projectId, amount, description);
	}

	@Override
	public void donate(int projectId, int amount) throws DataBaseException, SQLException {
		payments.donate(projectId, amount);
	}

	@Override
	public List<PaymentVariant> getPaymentVariants(int projectId) throws DataBaseException, SQLException {
		return payments.getPaymentVariants(projectId);
	}

	@Override
	public PaymentVariant getPaymentVariant(int id, int projectId) throws DataBaseException, SQLException {
		return payments.getPaymentVariant(id, projectId);
	}

	@Override
	public void createTablePayments() throws DataBaseException, SQLException {
		payments.createTablePayments();
	}

	private void createTables() throws DataBaseException, SQLException {
		createTableQuotes();
		createTableCategories();
		createTableProjects();
		createTableQuestions();
		createTablePayments();
	}

	private void setDefaultsData() throws DataBaseException, SQLException {
		addQuote("Don't cry because it's over, smile because it happened");
		addQuote("Be yourself; everyone else is already taken.");
		addQuote("A room without books is like a body without a soul.");

		addCategory("Sport");
		addCategory("Business");

		addProject(1, "velo parking", "velo parking in Kiev", 10000, 100, "History1", "www.project1.com");
		addProject(1, "velo track", "velo track in Kiev", 100000, 200, "History2", "www.project2.com");
		addProject(2, "IT-school", "IT - future of Ukraine", 1000000, 1000, "History3", "www.project3.com");

		donate(1, 500);
		donate(2, 5000);
		donate(3, 50000);

		addPaymentVariant(1, 10, "minimum");
		addPaymentVariant(1, 100, "medium");
		addPaymentVariant(1, 500, "high");
		addPaymentVariant(2, 10000, "standart");
		addPaymentVariant(3, 50000, "standart");

		addQuestion(1, "WTF �1?");
		addQuestion(2, "WTF �2?");
		addQuestion(3, "WTF �3?");
	}
}
