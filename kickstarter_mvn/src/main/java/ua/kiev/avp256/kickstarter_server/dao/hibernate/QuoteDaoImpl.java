package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import ua.kiev.avp256.kickstarter_server.dao.QuoteDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.Quote;

public class QuoteDaoImpl implements QuoteDao {
	private DaoSupport daoSupport;

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public void persist(Quote quote) {
		daoSupport.persist(quote);
	}

	@Override
	public Quote loadRandom() {
		List<?> result = daoSupport.getCurrentSession().getNamedQuery("loadRandomQuote").setMaxResults(1).list();

		daoSupport.check(result);

		return (Quote) result.get(0);
	}

	@Override
	public Quote load(int id) {
		return daoSupport.load(id, Quote.class);
	}
}
