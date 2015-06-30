package kickstarter.dao;

import kickstarter.entity.Quote;

public class QuoteDAOImpl extends AbstractDAO<Quote> {
	public QuoteDAOImpl() {
		super("Quote", "order by random()", "");
	}
}
