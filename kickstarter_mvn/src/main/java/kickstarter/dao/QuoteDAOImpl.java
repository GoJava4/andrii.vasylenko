package kickstarter.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import kickstarter.entity.Quote;

public class QuoteDAOImpl extends HibernateDaoSupport implements QuoteDAO {

	@Override
	public Quote getRandomQuote() {
		List<?> find = getHibernateTemplate().find("from Quote order by random()");
		return (Quote) find.get(0);
	}

}
