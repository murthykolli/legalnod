package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.ScorporationFormsAttributesAndValuesSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * ScorporationFormsAttributesAndValuesSaving entities. Transaction control of
 * the save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.ScorporationFormsAttributesAndValuesSaving
 * @author MyEclipse Persistence Tools
 */

public class ScorporationFormsAttributesAndValuesSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ScorporationFormsAttributesAndValuesSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String CORP_NAME = "corpName";
	public static final String SCORPORATION_FORMS_ATTRIBUTES_INFO_ID = "scorporationFormsAttributesInfoId";
	public static final String CAPTURED_INFORMATION = "capturedInformation";

	protected void initDao() {
		// do nothing
	}

	public void save(
			ScorporationFormsAttributesAndValuesSaving transientInstance) {
		LOGGER.debug("saving ScorporationFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
//	Captured Info take from DB
	public List findByallSCorpFormsCapturedInfoFromDB(String userName, String userChoice) {
		LOGGER.debug("finding ScorporationFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from ScorporationFormsAttributesAndValuesSaving WHERE userName = '"+userName+"' and corpName = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ScorporationFormsAttributesAndValuesSaving findBySCorpFormsAttributesAndValuesFromDB(String userName, String userChoice) {
		logger.debug("finding ScorporationFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from ScorporationFormsAttributesAndValuesSaving WHERE userName = '"+userName+"' and corpName = '"+userChoice+"'";
			
			return (ScorporationFormsAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(
			ScorporationFormsAttributesAndValuesSaving persistentInstance) {
		LOGGER.debug("deleting ScorporationFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public ScorporationFormsAttributesAndValuesSaving findById(
			java.lang.Integer id) {
		LOGGER.debug("getting ScorporationFormsAttributesAndValuesSaving instance with id: "
				+ id);
		try {
			ScorporationFormsAttributesAndValuesSaving instance = (ScorporationFormsAttributesAndValuesSaving) getHibernateTemplate()
					.get("com.legalnod.model.ScorporationFormsAttributesAndValuesSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ScorporationFormsAttributesAndValuesSaving> findByExample(
			ScorporationFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("finding ScorporationFormsAttributesAndValuesSaving instance by example");
		try {
			List<ScorporationFormsAttributesAndValuesSaving> results = (List<ScorporationFormsAttributesAndValuesSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding ScorporationFormsAttributesAndValuesSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ScorporationFormsAttributesAndValuesSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ScorporationFormsAttributesAndValuesSaving> findByUserName(
			Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<ScorporationFormsAttributesAndValuesSaving> findByCorpName(
			Object corpName) {
		return findByProperty(CORP_NAME, corpName);
	}

	public List<ScorporationFormsAttributesAndValuesSaving> findByScorporationFormsAttributesInfoId(
			Object scorporationFormsAttributesInfoId) {
		return findByProperty(SCORPORATION_FORMS_ATTRIBUTES_INFO_ID,
				scorporationFormsAttributesInfoId);
	}

	public List<ScorporationFormsAttributesAndValuesSaving> findByCapturedInformation(
			Object capturedInformation) {
		return findByProperty(CAPTURED_INFORMATION, capturedInformation);
	}

	public List findAll() {
		LOGGER.debug("finding all ScorporationFormsAttributesAndValuesSaving instances");
		try {
			String queryString = "from ScorporationFormsAttributesAndValuesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ScorporationFormsAttributesAndValuesSaving merge(
			ScorporationFormsAttributesAndValuesSaving detachedInstance) {
		LOGGER.debug("merging ScorporationFormsAttributesAndValuesSaving instance");
		try {
			ScorporationFormsAttributesAndValuesSaving result = (ScorporationFormsAttributesAndValuesSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ScorporationFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching dirty ScorporationFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ScorporationFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching clean ScorporationFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ScorporationFormsAttributesAndValuesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ScorporationFormsAttributesAndValuesSavingDAOImpl) ctx
				.getBean("ScorporationFormsAttributesAndValuesSavingDAO");
	}
}