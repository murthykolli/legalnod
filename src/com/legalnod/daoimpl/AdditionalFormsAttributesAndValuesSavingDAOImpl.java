package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AdditionalFormsAttributesAndValuesSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdditionalFormsAttributesAndValuesSaving entities. Transaction control of the
 * save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AdditionalFormsAttributesAndValuesSaving
 * @author MyEclipse Persistence Tools
 */

public class AdditionalFormsAttributesAndValuesSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdditionalFormsAttributesAndValuesSavingDAOImpl.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_CHOICE = "userChoice";
	public static final String ADDITIONAL_FORMS_ATTRIBUTES_INFO_ID = "additionalFormsAttributesInfoId";
	public static final String CAPTURED_INFORMATION = "capturedInformation";

	protected void initDao() {
		// do nothing
	}
	
	public AdditionalFormsAttributesAndValuesSaving findByAddSerFormsAttributesAndValuesFromDB(int userId, int formId, String userChoice) {
		LOGGER.debug("finding AdditionalFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from AdditionalFormsAttributesAndValuesSaving WHERE userId = '"+userId+"' and forms = '"+formId+"' and userChoice = '"+userChoice+"'";
			
			return (AdditionalFormsAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByAddtionalSerViceFormsCapturedInfoFromDB(int userId, int formId, String userChoice) {
		LOGGER.debug("finding AdditionalFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from AdditionalFormsAttributesAndValuesSaving WHERE userId = '"+userId+"' and forms = '"+formId+"' and userChoice = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void save(AdditionalFormsAttributesAndValuesSaving transientInstance) {
		LOGGER.debug("saving AdditionalFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(
			AdditionalFormsAttributesAndValuesSaving persistentInstance) {
		LOGGER.debug("deleting AdditionalFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AdditionalFormsAttributesAndValuesSaving findById(
			java.lang.Integer id) {
		LOGGER.debug("getting AdditionalFormsAttributesAndValuesSaving instance with id: "
				+ id);
		try {
			AdditionalFormsAttributesAndValuesSaving instance = (AdditionalFormsAttributesAndValuesSaving) getHibernateTemplate()
					.get("com.legalnod.model.AdditionalFormsAttributesAndValuesSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdditionalFormsAttributesAndValuesSaving> findByExample(
			AdditionalFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("finding AdditionalFormsAttributesAndValuesSaving instance by example");
		try {
			List<AdditionalFormsAttributesAndValuesSaving> results = (List<AdditionalFormsAttributesAndValuesSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AdditionalFormsAttributesAndValuesSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdditionalFormsAttributesAndValuesSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AdditionalFormsAttributesAndValuesSaving> findByUserId(
			Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<AdditionalFormsAttributesAndValuesSaving> findByUserChoice(
			Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List<AdditionalFormsAttributesAndValuesSaving> findByAdditionalFormsAttributesInfoId(
			Object additionalFormsAttributesInfoId) {
		return findByProperty(ADDITIONAL_FORMS_ATTRIBUTES_INFO_ID,
				additionalFormsAttributesInfoId);
	}

	public List<AdditionalFormsAttributesAndValuesSaving> findByCapturedInformation(
			Object capturedInformation) {
		return findByProperty(CAPTURED_INFORMATION, capturedInformation);
	}

	public List findAll() {
		LOGGER.debug("finding all AdditionalFormsAttributesAndValuesSaving instances");
		try {
			String queryString = "from AdditionalFormsAttributesAndValuesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdditionalFormsAttributesAndValuesSaving merge(
			AdditionalFormsAttributesAndValuesSaving detachedInstance) {
		LOGGER.debug("merging AdditionalFormsAttributesAndValuesSaving instance");
		try {
			AdditionalFormsAttributesAndValuesSaving result = (AdditionalFormsAttributesAndValuesSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdditionalFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching dirty AdditionalFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdditionalFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching clean AdditionalFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdditionalFormsAttributesAndValuesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdditionalFormsAttributesAndValuesSavingDAOImpl) ctx
				.getBean("AdditionalFormsAttributesAndValuesSavingDAO");
	}
}