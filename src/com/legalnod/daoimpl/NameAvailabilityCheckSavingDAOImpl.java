package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.dao.NameAvailabilityCheckSavingDAO;
import com.legalnod.model.NameAvailabilityCheckSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * NameAvailabilityCheckSaving entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.NameAvailabilityCheckSaving
 * @author MyEclipse Persistence Tools
 */

public class NameAvailabilityCheckSavingDAOImpl extends HibernateDaoSupport implements NameAvailabilityCheckSavingDAO{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(NameAvailabilityCheckSavingDAOImpl.class);
	
	// property constants
	public static final String USER_EMAIL = "userEmail";
	public static final String BUSINESS_STATE = "businessState";
	public static final String COMPANY_FORMING = "companyForming";
	public static final String DESCRIPTION = "description";
	public static final String BUSINESS_NAME = "businessName";
	public static final String ALTERNATE_NAME1 = "alternateName1";
	public static final String ALTERNATE_NAME2 = "alternateName2";
	public static final String ALTERNATE_NAME3 = "alternateName3";
	public static final String ALTERNATE_NAME4 = "alternateName4";
	public static final String STATUS = "status";

	protected void initDao() {
		// do nothing
	}

	public void save(NameAvailabilityCheckSaving transientInstance) {
		LOGGER.debug("saving NameAvailabilityCheckSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);			
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(NameAvailabilityCheckSaving persistentInstance) {
		LOGGER.debug("deleting NameAvailabilityCheckSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public NameAvailabilityCheckSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting NameAvailabilityCheckSaving instance with id: " + id);
		try {
			NameAvailabilityCheckSaving instance = (NameAvailabilityCheckSaving) getHibernateTemplate()
					.get("com.legalnod.model.NameAvailabilityCheckSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<NameAvailabilityCheckSaving> findByExample(
			NameAvailabilityCheckSaving instance) {
		LOGGER.debug("finding NameAvailabilityCheckSaving instance by example");
		try {
			List<NameAvailabilityCheckSaving> results = (List<NameAvailabilityCheckSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding NameAvailabilityCheckSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from NameAvailabilityCheckSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NameAvailabilityCheckSaving> findByUserEmail(Object userEmail) {
		return findByProperty(USER_EMAIL, userEmail);
	}

	public List<NameAvailabilityCheckSaving> findByBusinessState(
			Object businessState) {
		return findByProperty(BUSINESS_STATE, businessState);
	}

	public List<NameAvailabilityCheckSaving> findByCompanyForming(
			Object companyForming) {
		return findByProperty(COMPANY_FORMING, companyForming);
	}

	public List<NameAvailabilityCheckSaving> findByDescription(
			Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<NameAvailabilityCheckSaving> findByBusinessName(
			Object businessName) {
		return findByProperty(BUSINESS_NAME, businessName);
	}

	public List<NameAvailabilityCheckSaving> findByAlternateName1(
			Object alternateName1) {
		return findByProperty(ALTERNATE_NAME1, alternateName1);
	}

	public List<NameAvailabilityCheckSaving> findByAlternateName2(
			Object alternateName2) {
		return findByProperty(ALTERNATE_NAME2, alternateName2);
	}

	public List<NameAvailabilityCheckSaving> findByAlternateName3(
			Object alternateName3) {
		return findByProperty(ALTERNATE_NAME3, alternateName3);
	}

	public List<NameAvailabilityCheckSaving> findByAlternateName4(
			Object alternateName4) {
		return findByProperty(ALTERNATE_NAME4, alternateName4);
	}

	public List<NameAvailabilityCheckSaving> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		LOGGER.debug("finding all NameAvailabilityCheckSaving instances");
		try {
			String queryString = "from NameAvailabilityCheckSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public NameAvailabilityCheckSaving merge(
			NameAvailabilityCheckSaving detachedInstance) {
		LOGGER.debug("merging NameAvailabilityCheckSaving instance");
		try {
			NameAvailabilityCheckSaving result = (NameAvailabilityCheckSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NameAvailabilityCheckSaving instance) {
		LOGGER.debug("attaching dirty NameAvailabilityCheckSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NameAvailabilityCheckSaving instance) {
		LOGGER.debug("attaching clean NameAvailabilityCheckSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static NameAvailabilityCheckSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (NameAvailabilityCheckSavingDAOImpl) ctx
				.getBean("NameAvailabilityCheckSavingDAO");
	}
}