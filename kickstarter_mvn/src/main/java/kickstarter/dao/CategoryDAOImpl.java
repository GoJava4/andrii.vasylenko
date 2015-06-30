package kickstarter.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import kickstarter.entity.Category;

public class CategoryDAOImpl extends HibernateDaoSupport implements CategoryDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		return (List<Category>) getHibernateTemplate().find("from Category");
	}

}
