package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.FivezerooneAppFormsAttributesAndValuesSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * FivezerooneAppFormsAttributesAndValuesSaving entities. Transaction control of
 * the save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.FivezerooneAppFormsAttributesAndValuesSaving
 * @author MyEclipse Persistence Tools
 */

public class FivezerooneAppFormsAttributesAndValuesSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FivezerooneAppFormsAttributesAndValuesSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String APP_NAME = "appName";
	public static final String FIVEZEROONE_APP_FORMS_ATTRIBUTES_INFO_ID = "fivezerooneAppFormsAttributesInfoId";
	public static final String CAPTURED_INFORMATION = "capturedInformation";

	protected void initDao() {
		// do nothing
	}

	public void save(
			FivezerooneAppFormsAttributesAndValuesSaving transientInstance) {
		LOGGER.debug("saving FivezerooneAppFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
//	Captured Info take from DB
	public List findByallFZOFormsCapturedInfoFromDB(String userName, String userChoice) {
		LOGGER.debug("finding FivezerooneAppFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from FivezerooneAppFormsAttributesAndValuesSaving WHERE userName = '"+userName+"' and appName = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FivezerooneAppFormsAttributesAndValuesSaving findByFZOFormsAttributesAndValuesFromDB(String userName, String userChoice) {
		logger.debug("finding FivezerooneAppFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from FivezerooneAppFormsAttributesAndValuesSaving WHERE userName = '"+userName+"' and appName = '"+userChoice+"'";
			
			return (FivezerooneAppFormsAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(
			FivezerooneAppFormsAttributesAndValuesSaving persistentInstance) {
		LOGGER.debug("deleting FivezerooneAppFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public FivezerooneAppFormsAttributesAndValuesSaving findById(
			java.lang.Integer id) {
		LOGGER.debug("getting FivezerooneAppFormsAttributesAndValuesSaving instance with id: "
				+ id);
		try {
			FivezerooneAppFormsAttributesAndValuesSaving instance = (FivezerooneAppFormsAttributesAndValuesSaving) getHibernateTemplate()
					.get("com.legalnod.model.FivezerooneAppFormsAttributesAndValuesSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FivezerooneAppFormsAttributesAndValuesSaving> findByExample(
			FivezerooneAppFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("finding FivezerooneAppFormsAttributesAndValuesSaving instance by example");
		try {
			List<FivezerooneAppFormsAttributesAndValuesSaving> results = (List<FivezerooneAppFormsAttributesAndValuesSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding FivezerooneAppFormsAttributesAndValuesSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FivezerooneAppFormsAttributesAndValuesSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FivezerooneAppFormsAttributesAndValuesSaving> findByUserName(
			Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<FivezerooneAppFormsAttributesAndValuesSaving> findByAppName(
			Object appName) {
		return findByProperty(APP_NAME, appName);
	}

	public List<FivezerooneAppFormsAttributesAndValuesSaving> findByFivezerooneAppFormsAttributesInfoId(
			Object fivezerooneAppFormsAttributesInfoId) {
		return findByProperty(FIVEZEROONE_APP_FORMS_ATTRIBUTES_INFO_ID,
				fivezerooneAppFormsAttributesInfoId);
	}

	public List<FivezerooneAppFormsAttributesAndValuesSaving> findByCapturedInformation(
			Object capturedInformation) {
		return findByProperty(CAPTURED_INFORMATION, capturedInformation);
	}

	public List findAll() {
		LOGGER.debug("finding all FivezerooneAppFormsAttributesAndValuesSaving instances");
		try {
			String queryString = "from FivezerooneAppFormsAttributesAndValuesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FivezerooneAppFormsAttributesAndValuesSaving merge(
			FivezerooneAppFormsAttributesAndValuesSaving detachedInstance) {
		LOGGER.debug("merging FivezerooneAppFormsAttributesAndValuesSaving instance");
		try {
			FivezerooneAppFormsAttributesAndValuesSaving result = (FivezerooneAppFormsAttributesAndValuesSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(
			FivezerooneAppFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching dirty FivezerooneAppFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(
			FivezerooneAppFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching clean FivezerooneAppFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FivezerooneAppFormsAttributesAndValuesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FivezerooneAppFormsAttributesAndValuesSavingDAOImpl) ctx
				.getBean("FivezerooneAppFormsAttributesAndValuesSavingDAO");
	}
}