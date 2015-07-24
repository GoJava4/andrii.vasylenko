package ua.kiev.avp256.kickstarter_client.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.kiev.avp256.kickstarter_client.service.Client;
import ua.kiev.avp256.kickstarter_server.entity.Project;

@ManagedBean
@ViewScoped
public class ProjectsBean implements Serializable {
	private static final long serialVersionUID = 4608449442559255176L;

	private int categoryId;
	private List<Project> projects;

	@ManagedProperty(value = "#{client}")
	private Client client;

	public List<Project> getProjects() {
		return projects;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
		init();
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private void init() {
		projects = client.getEntitiesList("project/category/" + categoryId, Project.class);
	}
}
