package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.FederalTaxIdFormsAttributesAndValuesSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * FederalTaxIdFormsAttributesAndValuesSaving entities. Transaction control of
 * the save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.FederalTaxIdFormsAttributesAndValuesSaving
 * @author MyEclipse Persistence Tools
 */

public class FederalTaxIdFormsAttributesAndValuesSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FederalTaxIdFormsAttributesAndValuesSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String LEGAL_NAME = "legalName";
	public static final String FEDERAL_TAX_ID_FORMS_ATTRIBUTES_INFO_ID = "federalTaxIdFormsAttributesInfoId";
	public static final String CAPTURED_INFORMATION = "capturedInformation";

	protected void initDao() {
		// do nothing
	}

	public void save(
			FederalTaxIdFormsAttributesAndValuesSaving transientInstance) {
		LOGGER.debug("saving FederalTaxIdFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
//	Captured Info take from DB
	public List findByallFederalFormsCapturedInfoFromDB(String userName, String userChoice) {
		LOGGER.debug("finding FederalTaxIdFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from FederalTaxIdFormsAttributesAndValuesSaving WHERE userName = '"+userName+"' and legalName = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FederalTaxIdFormsAttributesAndValuesSaving findByFederalTaxFormsAttributesAndValuesFromDB(String userName, String userChoice) {
		logger.debug("finding FederalTaxIdFormsAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from FederalTaxIdFormsAttributesAndValuesSaving WHERE userName = '"+userName+"' and legalName = '"+userChoice+"'";
			
			return (FederalTaxIdFormsAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(
			FederalTaxIdFormsAttributesAndValuesSaving persistentInstance) {
		LOGGER.debug("deleting FederalTaxIdFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public FederalTaxIdFormsAttributesAndValuesSaving findById(
			java.lang.Integer id) {
		LOGGER.debug("getting FederalTaxIdFormsAttributesAndValuesSaving instance with id: "
				+ id);
		try {
			FederalTaxIdFormsAttributesAndValuesSaving instance = (FederalTaxIdFormsAttributesAndValuesSaving) getHibernateTemplate()
					.get("com.legalnod.model.FederalTaxIdFormsAttributesAndValuesSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FederalTaxIdFormsAttributesAndValuesSaving> findByExample(
			FederalTaxIdFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("finding FederalTaxIdFormsAttributesAndValuesSaving instance by example");
		try {
			List<FederalTaxIdFormsAttributesAndValuesSaving> results = (List<FederalTaxIdFormsAttributesAndValuesSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding FederalTaxIdFormsAttributesAndValuesSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FederalTaxIdFormsAttributesAndValuesSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FederalTaxIdFormsAttributesAndValuesSaving> findByUserName(
			Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<FederalTaxIdFormsAttributesAndValuesSaving> findByLegalName(
			Object legalName) {
		return findByProperty(LEGAL_NAME, legalName);
	}

	public List<FederalTaxIdFormsAttributesAndValuesSaving> findByFederalTaxIdFormsAttributesInfoId(
			Object federalTaxIdFormsAttributesInfoId) {
		return findByProperty(FEDERAL_TAX_ID_FORMS_ATTRIBUTES_INFO_ID,
				federalTaxIdFormsAttributesInfoId);
	}

	public List<FederalTaxIdFormsAttributesAndValuesSaving> findByCapturedInformation(
			Object capturedInformation) {
		return findByProperty(CAPTURED_INFORMATION, capturedInformation);
	}

	public List findAll() {
		LOGGER.debug("finding all FederalTaxIdFormsAttributesAndValuesSaving instances");
		try {
			String queryString = "from FederalTaxIdFormsAttributesAndValuesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FederalTaxIdFormsAttributesAndValuesSaving merge(
			FederalTaxIdFormsAttributesAndValuesSaving detachedInstance) {
		LOGGER.debug("merging FederalTaxIdFormsAttributesAndValuesSaving instance");
		try {
			FederalTaxIdFormsAttributesAndValuesSaving result = (FederalTaxIdFormsAttributesAndValuesSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FederalTaxIdFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching dirty FederalTaxIdFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FederalTaxIdFormsAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching clean FederalTaxIdFormsAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FederalTaxIdFormsAttributesAndValuesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FederalTaxIdFormsAttributesAndValuesSavingDAOImpl) ctx
				.getBean("FederalTaxIdFormsAttributesAndValuesSavingDAO");
	}
}