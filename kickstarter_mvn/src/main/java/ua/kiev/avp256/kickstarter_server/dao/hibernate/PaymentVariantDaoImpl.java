package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;

public class PaymentVariantDaoImpl implements PaymentVariantDao {
	private DaoSupport daoSupport;

	@Override
	public void persist(PaymentVariant paymentVariant) {
		daoSupport.persist(paymentVariant);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PaymentVariant> loadPaymentVariantsInProject(int projectId) {
		List<?> result = daoSupport.getCurrentSession().createCriteria(PaymentVariant.class)
				.add(Restrictions.eq("project.id", projectId)).list();

		daoSupport.check(result);

		return (List<PaymentVariant>) result;
	}

	@Override
	public PaymentVariant load(int id) {
		return daoSupport.load(id, PaymentVariant.class);
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
