package kickstarter.entity;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;
import org.joda.time.Days;

@XmlRootElement
public class Project implements Serializable {
	private static final long serialVersionUID = -5672417376734008303L;

	private int id;
	private Category category;
	private String name;
	private String description;
	private int totalAmount;
	private DateTime finalDate;
	private String history;
	private String link;
	private Set<Payment> payments;
	private Set<Question> questions;
	private Set<PaymentVariant> paymentVariants;
	private Integer collectAmount;

	public int getDaysLeft() {
		return Days.daysBetween(DateTime.now(), getFinalDate()).getDays();
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

	public DateTime getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(DateTime finalDate) {
		this.finalDate = finalDate;
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

	public Integer getCollectAmount() {
		return collectAmount;
	}

	public void setCollectAmount(Integer collectAmount) {
		this.collectAmount = collectAmount;
	}
}
