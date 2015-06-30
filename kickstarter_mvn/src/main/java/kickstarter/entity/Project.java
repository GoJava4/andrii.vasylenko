package kickstarter.entity;

import java.io.Serializable;
import java.util.Set;

public class Project implements Serializable {
	private static final long serialVersionUID = -5672417376734008303L;

	private int id;
	private Category category;
	private String name;
	private String description;
	private int totalAmount;
	private int daysLeft;
	private int collectAmount;
	private String history;
	private String link;
	private Set<Payment> payments;
	private Set<Question> questions;
	private Set<PaymentVariant> paymentVariants;

	public int getCollectAmount() {
		return collectAmount;
	}

	private void calcCollectAmount() {
		collectAmount = 0;
		for (Payment payment : payments) {
			collectAmount += payment.getAmount();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
		calcCollectAmount();
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<PaymentVariant> getPaymentVariants() {
		return paymentVariants;
	}

	public void setPaymentVariants(Set<PaymentVariant> paymentVariants) {
		this.paymentVariants = paymentVariants;
	}
}
