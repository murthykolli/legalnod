package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.StateTaxFormsAttributesAndValuesSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * StateTaxFormsAttributesAndValuesSaving entities. Transaction control of the
 * save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.StateTaxFormsAttributesAndValuesSaving
 * @author MyEclipse Persistence Tools
 */

public class StateTaxFormsAttributesAndValuesSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StateTaxFormsAttributesAndValuesSavingDAOImpl.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_CHOICE = "userChoice";
	public static final String STATE_TAX_FORMS_ATTRIBUTES_INFO_ID = "stateTaxFormsAttributesInfoId";
	public static final String CAPTURED_INFORMATION = "capturedInformation";

	protected void initDao() {
		// do nothing
	}
	
	public StateTaxFormsAttributesAndValuesSaving findByStateTaxIdFormsAttributesAndValuesFromDB(int userId, int formId, String userChoice) {
		logger.debug("finding StateTaxFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from StateTaxFormsAttributesAndValuesSaving WHERE userId = '"+userId+"' and forms = '"+formId+"' and userChoice = '"+userChoice+"'";
			
			return (StateTaxFormsAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByallStateTaxIdFormsCapturedInfoFromDB(int userId, int formId, String userChoice) {
		logger.debug("finding StateTaxFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from StateTaxFormsAttributesAndValuesSaving WHERE userId = '"+userId+"' and forms = '"+formId+"' and userChoice = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void save(StateTaxFormsAttributesAndValuesSaving transientInstance) {
		LOGGER.debug("saving StateTaxFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(StateTaxFormsAttributesAndValuesSaving persistentInstance) {
		LOGGER.debug("deleting StateTaxFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public StateTaxFormsAttributesAndValuesSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting StateTaxFormsAttributesAndValuesSaving instance with id: "
				+ id);
		try {
			StateTaxFormsAttributesAndValuesSaving instance = (StateTaxFormsAttributesAndValuesSaving) getHibernateTemplate()
					.get("com.legalnod.model.StateTaxFormsAttributesAndValuesSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<StateTaxFormsAttributesAndValuesSaving> findByExample(
			StateTaxFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("finding StateTaxFormsAttributesAndValuesSaving instance by example");
		try {
			List<StateTaxFormsAttributesAndValuesSaving> results = (List<StateTaxFormsAttributesAndValuesSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding StateTaxFormsAttributesAndValuesSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StateTaxFormsAttributesAndValuesSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<StateTaxFormsAttributesAndValuesSaving> findByUserId(
			Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<StateTaxFormsAttributesAndValuesSaving> findByUserChoice(
			Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List<StateTaxFormsAttributesAndValuesSaving> findByStateTaxFormsAttributesInfoId(
			Object stateTaxFormsAttributesInfoId) {
		return findByProperty(STATE_TAX_FORMS_ATTRIBUTES_INFO_ID,
				stateTaxFormsAttributesInfoId);
	}

	public List<StateTaxFormsAttributesAndValuesSaving> findByCapturedInformation(
			Object capturedInformation) {
		return findByProperty(CAPTURED_INFORMATION, capturedInformation);
	}

	public List findAll() {
		LOGGER.debug("finding all StateTaxFormsAttributesAndValuesSaving instances");
		try {
			String queryString = "from StateTaxFormsAttributesAndValuesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public StateTaxFormsAttributesAndValuesSaving merge(
			StateTaxFormsAttributesAndValuesSaving detachedInstance) {
		LOGGER.debug("merging StateTaxFormsAttributesAndValuesSaving instance");
		try {
			StateTaxFormsAttributesAndValuesSaving result = (StateTaxFormsAttributesAndValuesSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StateTaxFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching dirty StateTaxFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StateTaxFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching clean StateTaxFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static StateTaxFormsAttributesAndValuesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (StateTaxFormsAttributesAndValuesSavingDAOImpl) ctx
				.getBean("StateTaxFormsAttributesAndValuesSavingDAO");
	}
}