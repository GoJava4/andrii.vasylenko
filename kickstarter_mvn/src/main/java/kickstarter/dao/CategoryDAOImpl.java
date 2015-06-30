package kickstarter.dao;

import kickstarter.entity.Category;

public class CategoryDAOImpl extends AbstractDAO<Category> {
	public CategoryDAOImpl() {
		super("Category", "", "");
	}
}
