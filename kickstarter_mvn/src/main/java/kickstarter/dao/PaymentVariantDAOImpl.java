package kickstarter.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import kickstarter.entity.PaymentVariant;

public class PaymentVariantDAOImpl extends HibernateDaoSupport implements PaymentVariantDAO {

	@Override
	public PaymentVariant getPaymentVariant(int id, int projectId) {
		List<?> find = getHibernateTemplate()
				.find("from PaymentVariant where id = ? and id_project = ?", id, projectId);
		return (PaymentVariant) find.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentVariant> getPaymentVariants(int projectId) {
		return (List<PaymentVariant>) getHibernateTemplate()
				.find("from PaymentVariant where id_project = ?", projectId);
	}

}
