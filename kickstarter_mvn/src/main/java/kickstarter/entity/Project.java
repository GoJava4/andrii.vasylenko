package kickstarter.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Project implements Serializable {
	private static final long serialVersionUID = -5672417376734008303L;

	private int id;
	private Category category;
	private String name;
	private String description;
	private int totalAmount;
	private int daysLeft;
	private Date finalDate;
	private int collectAmount;
	private String history;
	private String link;
	private Set<Payment> payments;
	private Set<Question> questions;
	private Set<PaymentVariant> paymentVariants;

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

	public int getDaysLeft() {
		return daysLeft;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public int getCollectAmount() {
		return collectAmount;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
		this.daysLeft = calcDaysLeft();
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
		this.collectAmount = calcCollectAmount();
	}

	private int calcDaysLeft() {
		long diff = finalDate.getTime() - System.currentTimeMillis();
		return (int) (diff / 1000 / 60 / 60 / 24);
	}

	private int calcCollectAmount() {
		int collectAmount = 0;
		for (Payment payment : payments) {
			collectAmount += payment.getAmount();
		}
		return collectAmount;
	}
}
