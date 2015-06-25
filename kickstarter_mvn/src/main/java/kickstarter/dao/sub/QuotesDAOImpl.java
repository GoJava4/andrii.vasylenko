package kickstarter.dao.sub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import kickstarter.dao.connection.ConnectionPool;
import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuotesDAOImpl implements QuotesDAO {
	private ConnectionPool connectionPool;

	public QuotesDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addQuote(String quote) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getInsertQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, quote);

			statement.executeUpdate();
		}
	}

	@Override
	public Quote getRandomQuote() throws DataBaseException, SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getSelectQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getQuote(resultQuery);
			} else {
				throw new DataBaseException("no any Quote");
			}
		}
	}

	@Override
	public void createTableQuotes() throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			Statement statement = connection.createStatement();
			String sql = getCreateQuery();
			statement.execute(sql);
		}
	}

	private Quote getQuote(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String qoute = result.getString("quote");

		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		Quote quote = (Quote) context.getBean("Quote", id, qoute);

		return quote;
	}

	private String getInsertQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Quotes ");
		sql.append("(quote) values(?)");
		return sql.toString();
	}

	private String getSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, quote ");
		sql.append("from Quotes ");
		sql.append("order by random() limit 1");
		return sql.toString();
	}

	private String getCreateQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("drop table IF EXISTS Quotes; ");
		sql.append("create table Quotes (");
		sql.append("id serial not null PRIMARY KEY, ");
		sql.append("quote varchar(255)");
		sql.append(")");
		return sql.toString();
	}
}
