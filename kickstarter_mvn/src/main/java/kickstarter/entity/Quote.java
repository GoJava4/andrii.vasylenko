package kickstarter.entity;

import java.io.Serializable;

public class Quote implements Serializable {
	private static final long serialVersionUID = -7177896743757665598L;

	private int id;
	private String quote;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
