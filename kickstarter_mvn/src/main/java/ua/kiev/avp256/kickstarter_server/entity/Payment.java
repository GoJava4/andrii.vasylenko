package ua.kiev.avp256.kickstarter_server.entity;

import java.io.Serializable;

public class Payment implements Serializable {
	private static final long serialVersionUID = -3116811010948870329L;

	private int id;
	private Project project;
	private int amount;

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
