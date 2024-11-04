package com.legalnod.daoimpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.BusinessFormsAttributesAndValuesSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * BusinessFormsAttributesAndValuesSaving entities. Transaction control of the
 * save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.BusinessFormsAttributesAndValuesSaving
 * @author MyEclipse Persistence Tools
 */

public class BusinessFormsAttributesAndValuesSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BusinessFormsAttributesAndValuesSavingDAOImpl.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_CHOICE = "userChoice";
	public static final String BUSINESS_FORMS_ATTRIBUTES_INFO_ID = "businessFormsAttributesInfoId";
	public static final String CAPTURED_INFORMATION = "capturedInformation";

	protected void initDao() {
		// do nothing
	}

	public void save(BusinessFormsAttributesAndValuesSaving transientInstance) {
		LOGGER.debug("saving BusinessFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public BusinessFormsAttributesAndValuesSaving findByBusinessFormsAttributesAndValuesFromDB(int userId, int formId, String userChoice) {
		logger.debug("finding BusinessFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from BusinessFormsAttributesAndValuesSaving WHERE userId = '"+userId+"' and forms = '"+formId+"' and userChoice = '"+userChoice+"'";
			
			return (BusinessFormsAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
	public BusinessFormsAttributesAndValuesSaving merge(
			BusinessFormsAttributesAndValuesSaving detachedInstance) {
		LOGGER.debug("merging BusinessFormsAttributesAndValuesSaving instance");
		try {
			BusinessFormsAttributesAndValuesSaving result = (BusinessFormsAttributesAndValuesSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}
	
	public List findByallStateFormsCapturedInfoFromDB(int userId, int formId, String userChoice) {
		logger.debug("finding BusinessFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from BusinessFormsAttributesAndValuesSaving WHERE userId = '"+userId+"' and forms = '"+formId+"' and userChoice = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
	

	public void delete(BusinessFormsAttributesAndValuesSaving persistentInstance) {
		LOGGER.debug("deleting BusinessFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public BusinessFormsAttributesAndValuesSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting BusinessFormsAttributesAndValuesSaving instance with id: "
				+ id);
		try {
			BusinessFormsAttributesAndValuesSaving instance = (BusinessFormsAttributesAndValuesSaving) getHibernateTemplate()
					.get("com.legalnod.model.BusinessFormsAttributesAndValuesSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<BusinessFormsAttributesAndValuesSaving> findByExample(
			BusinessFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("finding BusinessFormsAttributesAndValuesSaving instance by example");
		try {
			List<BusinessFormsAttributesAndValuesSaving> results = (List<BusinessFormsAttributesAndValuesSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding BusinessFormsAttributesAndValuesSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BusinessFormsAttributesAndValuesSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BusinessFormsAttributesAndValuesSaving> findByUserId(
			Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<BusinessFormsAttributesAndValuesSaving> findByUserChoice(
			Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List<BusinessFormsAttributesAndValuesSaving> findByBusinessFormsAttributesInfoId(
			Object businessFormsAttributesInfoId) {
		return findByProperty(BUSINESS_FORMS_ATTRIBUTES_INFO_ID,
				businessFormsAttributesInfoId);
	}

	public List<BusinessFormsAttributesAndValuesSaving> findByCapturedInformation(
			Object capturedInformation) {
		return findByProperty(CAPTURED_INFORMATION, capturedInformation);
	}

	public List findAll() {
		LOGGER.debug("finding all BusinessFormsAttributesAndValuesSaving instances");
		try {
			String queryString = "from BusinessFormsAttributesAndValuesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}	

	public void attachDirty(BusinessFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching dirty BusinessFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BusinessFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching clean BusinessFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static BusinessFormsAttributesAndValuesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (BusinessFormsAttributesAndValuesSavingDAOImpl) ctx
				.getBean("BusinessFormsAttributesAndValuesSavingDAO");
	}
}