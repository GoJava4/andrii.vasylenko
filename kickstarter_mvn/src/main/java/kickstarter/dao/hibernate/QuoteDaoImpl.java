package kickstarter.dao.hibernate;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kickstarter.dao.QuoteDao;
import kickstarter.dao.hibernate.support.DaoSupport;
import kickstarter.entity.Quote;
import kickstarter.exception.DataBaseException;

public class QuoteDaoImpl implements QuoteDao {
	private DaoSupport<Quote> daoSupport;

	public void setDaoSupport(DaoSupport<Quote> daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Transactional
	@Override
	public void persist(Quote quote) throws DataBaseException {
		daoSupport.persist(quote);
	}

	@Transactional(readOnly = true)
	@Override
	public Quote loadRandom() throws DataBaseException {
		List<?> result = daoSupport.getCurrentSession().getNamedQuery("loadRandomQuote").setMaxResults(1).list();

		daoSupport.check(result);

		return (Quote) result.get(0);
	}

	@Transactional(readOnly = true)
	@Override
	public Quote load(int id) throws DataBaseException {
		return daoSupport.load(id, Quote.class);
	}
}