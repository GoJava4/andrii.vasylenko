package kickstarter.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPoolImpl implements ConnectionPool {
	private static volatile DataSource connectionPool;

	public ConnectionPoolImpl() throws NamingException {
		InitialContext initCtx = new InitialContext();
		connectionPool = (DataSource) initCtx.lookup("java:comp/env/jdbc/kickstarter");
	}

	@Override
	public Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}
}
