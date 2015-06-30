package kickstarter.entity;

import java.io.Serializable;

public class Question implements Serializable {
	private static final long serialVersionUID = 6929287121626797490L;

	private int id;
	private Project project;
	private String question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
