package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.FormFederalAttributesAndValuesSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * FormFederalAttributesAndValuesSaving entities. Transaction control of the
 * save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.FormFederalAttributesAndValuesSaving
 * @author MyEclipse Persistence Tools
 */

public class FormFederalAttributesAndValuesSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FormFederalAttributesAndValuesSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String LEGAL_NAME = "legalName";
	public static final String FORM_NAME = "formName";
	public static final String STATE_NAME = "stateName";
	public static final String USER_CHOICE = "userChoice";
	public static final String FEDERAL_TAX_ID_FORMS_ATTRIBUTES_INFO_ID = "federalTaxIdFormsAttributesInfoId";
	public static final String CAPTURED_INFORMATION = "capturedInformation";

	protected void initDao() {
		// do nothing
	}
	
//	Captured Info take from DB
	public List formFederalFormsCapturedInfoFromDB(String userName, String formName, String stateName, String userChoice, String legalName) {
		LOGGER.debug("finding FormFederalAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from FormFederalAttributesAndValuesSaving WHERE userName = '"+userName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' and legalName = '"+legalName+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FormFederalAttributesAndValuesSaving freeFederalTaxFormsAttributesAndValuesFromDB(String userName, String formName, String stateName, String userChoice, String legalName) {
		logger.debug("finding FormFederalAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from FormFederalAttributesAndValuesSaving WHERE userName = '"+userName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' and legalName = '"+legalName+"'";
			
			return (FormFederalAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
//	State forms user choice update in Form Federal Attributes And ValuesSaving DB
	
	public FormFederalAttributesAndValuesSaving stateFormsUserChoiceUpdateInAttrAndValuesDB(String userName, String formName, String stateName, String userChoice) {
		logger.debug("finding FormFederalAttributesAndValuesSaving instance with property: ");		
		try {
			String queryString = "from FormFederalAttributesAndValuesSaving WHERE userName = '"+userName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"'";
			
			return (FormFederalAttributesAndValuesSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public void save(FormFederalAttributesAndValuesSaving transientInstance) {
		LOGGER.debug("saving FormFederalAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(FormFederalAttributesAndValuesSaving persistentInstance) {
		LOGGER.debug("deleting FormFederalAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public FormFederalAttributesAndValuesSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting FormFederalAttributesAndValuesSaving instance with id: "
				+ id);
		try {
			FormFederalAttributesAndValuesSaving instance = (FormFederalAttributesAndValuesSaving) getHibernateTemplate()
					.get("com.legalnod.model.FormFederalAttributesAndValuesSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FormFederalAttributesAndValuesSaving> findByExample(
			FormFederalAttributesAndValuesSaving instance) {
		LOGGER.debug("finding FormFederalAttributesAndValuesSaving instance by example");
		try {
			List<FormFederalAttributesAndValuesSaving> results = (List<FormFederalAttributesAndValuesSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding FormFederalAttributesAndValuesSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FormFederalAttributesAndValuesSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FormFederalAttributesAndValuesSaving> findByUserName(
			Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<FormFederalAttributesAndValuesSaving> findByLegalName(
			Object legalName) {
		return findByProperty(LEGAL_NAME, legalName);
	}

	public List<FormFederalAttributesAndValuesSaving> findByFormName(
			Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<FormFederalAttributesAndValuesSaving> findByStateName(
			Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<FormFederalAttributesAndValuesSaving> findByUserChoice(
			Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List<FormFederalAttributesAndValuesSaving> findByFederalTaxIdFormsAttributesInfoId(
			Object federalTaxIdFormsAttributesInfoId) {
		return findByProperty(FEDERAL_TAX_ID_FORMS_ATTRIBUTES_INFO_ID,
				federalTaxIdFormsAttributesInfoId);
	}

	public List<FormFederalAttributesAndValuesSaving> findByCapturedInformation(
			Object capturedInformation) {
		return findByProperty(CAPTURED_INFORMATION, capturedInformation);
	}

	public List findAll() {
		LOGGER.debug("finding all FormFederalAttributesAndValuesSaving instances");
		try {
			String queryString = "from FormFederalAttributesAndValuesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FormFederalAttributesAndValuesSaving merge(
			FormFederalAttributesAndValuesSaving detachedInstance) {
		LOGGER.debug("merging FormFederalAttributesAndValuesSaving instance");
		try {
			FormFederalAttributesAndValuesSaving result = (FormFederalAttributesAndValuesSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FormFederalAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching dirty FormFederalAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FormFederalAttributesAndValuesSaving instance) {
		LOGGER.debug("attaching clean FormFederalAttributesAndValuesSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FormFederalAttributesAndValuesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FormFederalAttributesAndValuesSavingDAOImpl) ctx
				.getBean("FormFederalAttributesAndValuesSavingDAO");
	}
}