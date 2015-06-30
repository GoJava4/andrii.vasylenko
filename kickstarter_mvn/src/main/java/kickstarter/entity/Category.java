package kickstarter.entity;

import java.io.Serializable;
import java.util.Set;

public class Category implements Serializable {
	private static final long serialVersionUID = -3814189872666848087L;

	private int id;
	private String name;
	private Set<Project> projects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
