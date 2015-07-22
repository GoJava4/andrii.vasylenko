package ua.kiev.avp256.kickstarter_server.dao.hibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Restrictions;

import ua.kiev.avp256.kickstarter_server.dao.PaymentVariantDao;
import ua.kiev.avp256.kickstarter_server.dao.hibernate.support.DaoSupport;
import ua.kiev.avp256.kickstarter_server.entity.PaymentVariant;

public class PaymentVariantDaoImpl implements PaymentVariantDao {
	private static final Logger LOG = LogManager.getLogger(PaymentVariantDaoImpl.class);

	private DaoSupport daoSupport;

	@Override
	public void persist(PaymentVariant paymentVariant) {
		LOG.entry(paymentVariant);
		daoSupport.persist(paymentVariant);
		LOG.exit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PaymentVariant> loadPaymentVariantsInProject(int projectId) {
		LOG.entry(projectId);

		List<?> result = daoSupport.getCurrentSession().createCriteria(PaymentVariant.class)
				.add(Restrictions.eq("project.id", projectId)).list();

		daoSupport.check(result);

		return LOG.exit((List<PaymentVariant>) result);
	}

	@Override
	public PaymentVariant load(int id) {
		LOG.entry(id);
		return LOG.exit(daoSupport.load(id, PaymentVariant.class));
	}

	public void setDaoSupport(DaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}
}
