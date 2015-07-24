package ua.kiev.avp256.kickstarter_client.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.kiev.avp256.kickstarter_client.service.Client;
import ua.kiev.avp256.kickstarter_server.entity.Project;
import ua.kiev.avp256.kickstarter_server.entity.Question;

@ManagedBean
@ViewScoped
public class ProjectBean implements Serializable {
	private static final long serialVersionUID = 4608449442559255176L;

	private int id;
	private Project project;
	private List<Question> questions;

	@ManagedProperty(value = "#{client}")
	private Client client;

	public Project getProject() {
		return project;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		init();
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private void init() {
		project = client.getEntity("project/" + id, Project.class);
		questions = client.getEntitiesList("question/project/" + id, Question.class);
	}
}
