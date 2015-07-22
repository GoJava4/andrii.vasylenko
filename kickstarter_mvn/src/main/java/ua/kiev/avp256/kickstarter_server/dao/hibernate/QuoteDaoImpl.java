package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.kiev.avp256.kickstarter_server.dao.QuoteDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Quote;

public class QuoteDaoImpl implements QuoteDao {
	private static final Logger LOG = LogManager.getLogger(QuoteDaoImpl.class);

	private DaoSupport daoSupport;

	@Override
	public void persist(Quote quote) {
		LOG.entry(quote);
		daoSupport.persist(quote);
		LOG.exit();
	}

	@Override
	public Quote loadRandom() {
		LOG.entry();

		List<?> result = daoSupport.getCurrentSession().getNamedQuery("loadRandomQuote").setMaxResults(1).list();

		daoSupport.check(result);

		return LOG.exit((Quote) result.get(0));
	}

	@Override
	public Quote load(int id) {
		LOG.entry(id);
		return LOG.exit(daoSupport.load(id, Quote.class));
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
