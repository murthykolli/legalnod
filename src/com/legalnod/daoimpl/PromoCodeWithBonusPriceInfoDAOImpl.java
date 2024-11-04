package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.PromoCodeWithBonusPriceInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * PromoCodeWithBonusPriceInfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.PromoCodeWithBonusPriceInfo
 * @author MyEclipse Persistence Tools
 */

public class PromoCodeWithBonusPriceInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PromoCodeWithBonusPriceInfoDAOImpl.class);

	// property constants

	protected void initDao() {
		// do nothing
	}
	
//	Take Bonus value from DB using Promo code	
	
	public List promoCodeBonusPriceTakeFromDB(String promoCode) {
		LOGGER.debug("finding PromoCodeWithBonusPriceInfo instance with Form promoCode: "
				+ promoCode );
		try {
			String queryString = "select bonusPrice from PromoCodeWithBonusPriceInfo where promoCodeOption = '"+promoCode+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void save(PromoCodeWithBonusPriceInfo transientInstance) {
		LOGGER.debug("saving PromoCodeWithBonusPriceInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(PromoCodeWithBonusPriceInfo persistentInstance) {
		LOGGER.debug("deleting PromoCodeWithBonusPriceInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public List<PromoCodeWithBonusPriceInfo> findByExample(
			PromoCodeWithBonusPriceInfo instance) {
		LOGGER.debug("finding PromoCodeWithBonusPriceInfo instance by example");
		try {
			List<PromoCodeWithBonusPriceInfo> results = (List<PromoCodeWithBonusPriceInfo>) getHibernateTemplate()
					.findByExample(instance);
			LOGGER.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		LOGGER.debug("finding PromoCodeWithBonusPriceInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PromoCodeWithBonusPriceInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		LOGGER.debug("finding all PromoCodeWithBonusPriceInfo instances");
		try {
			String queryString = "from PromoCodeWithBonusPriceInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public PromoCodeWithBonusPriceInfo merge(
			PromoCodeWithBonusPriceInfo detachedInstance) {
		LOGGER.debug("merging PromoCodeWithBonusPriceInfo instance");
		try {
			PromoCodeWithBonusPriceInfo result = (PromoCodeWithBonusPriceInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PromoCodeWithBonusPriceInfo instance) {
		LOGGER.debug("attaching dirty PromoCodeWithBonusPriceInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PromoCodeWithBonusPriceInfo instance) {
		LOGGER.debug("attaching clean PromoCodeWithBonusPriceInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static PromoCodeWithBonusPriceInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (PromoCodeWithBonusPriceInfoDAOImpl) ctx
				.getBean("PromoCodeWithBonusPriceInfoDAO");
	}
}