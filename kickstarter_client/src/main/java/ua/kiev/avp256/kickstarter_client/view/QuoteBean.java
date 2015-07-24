package ua.kiev.avp256.kickstarter_client.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.kiev.avp256.kickstarter_client.service.Client;
import ua.kiev.avp256.kickstarter_server.entity.Quote;

@ManagedBean
@ViewScoped
public class QuoteBean implements Serializable {
	private static final long serialVersionUID = 4608449442559255176L;

	private Quote quote;

	@ManagedProperty(value = "#{client}")
	private Client client;

	@PostConstruct
	public void init() {
		quote = client.getEntity("quote/random", Quote.class);
	}

	public Quote getQuote() {
		return quote;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
