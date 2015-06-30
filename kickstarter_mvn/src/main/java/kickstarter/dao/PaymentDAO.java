package kickstarter.dao;

public interface PaymentDAO {
	void donate(int projectId, int amount);
}
