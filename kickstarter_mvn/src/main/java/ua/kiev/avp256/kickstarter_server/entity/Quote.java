package ua.kiev.avp256.kickstarter_server.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
