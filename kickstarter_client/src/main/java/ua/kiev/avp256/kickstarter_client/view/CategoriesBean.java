package ua.kiev.avp256.kickstarter_client.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.kiev.avp256.kickstarter_client.service.Client;
import ua.kiev.avp256.kickstarter_server.entity.Category;

@ManagedBean
@ViewScoped
public class CategoriesBean implements Serializable {
	private static final long serialVersionUID = 4608449442559255176L;

	private List<Category> categories;

	@ManagedProperty(value = "#{client}")
	private Client client;

	@PostConstruct
	public void init() {
		categories = client.getEntitiesList("category", Category.class);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
