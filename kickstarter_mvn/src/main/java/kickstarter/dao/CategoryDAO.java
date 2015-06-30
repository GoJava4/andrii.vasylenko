package kickstarter.dao;

import java.util.List;

import kickstarter.entity.Category;

public interface CategoryDAO {
	List<Category> getCategories();
}
