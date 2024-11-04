package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AllStateFormsPaymentInfoSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AllStateFormsPaymentInfoSaving entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AllStateFormsPaymentInfoSaving
 * @author MyEclipse Persistence Tools
 */

public class AllStateFormsPaymentInfoSavingDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AllStateFormsPaymentInfoSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String FORM_NAME = "formName";
	public static final String STATE_NAME = "stateName";
	public static final String USER_CHOICE = "userChoice";
	public static final String PROCESSING_FEE = "processingFee";
	public static final String STANDARD_FILING_FEE = "standardFilingFee";
	public static final String TOTAL_FEE = "totalFee";
	public static final String TYPE_OF_DOCUMENT = "typeOfDocument";
	public static final String ADD_TO_CART = "addToCart";
	public static final String FORM_FED_STATUS = "formFedStatus";
	public static final String REGISTERED_AGENT_PRICE = "registeredAgentPrice";

	protected void initDao() {
		// do nothing
	}

//	All State Forms Payment Info Saving Verification
	
	public List allStateFormsPaymentRowVerification(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsPaymentInfoSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllStateFormsPaymentInfoSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All State Forms Payment Info Modification Verification
	
	public AllStateFormsPaymentInfoSaving allStateFormsPaymentModificationVerification(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsPaymentInfoSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsPaymentInfoSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' ";
			return (AllStateFormsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void save(AllStateFormsPaymentInfoSaving transientInstance) {
		LOGGER.debug("saving AllStateFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(AllStateFormsPaymentInfoSaving persistentInstance) {
		LOGGER.debug("deleting AllStateFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AllStateFormsPaymentInfoSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting AllStateFormsPaymentInfoSaving instance with id: "
				+ id);
		try {
			AllStateFormsPaymentInfoSaving instance = (AllStateFormsPaymentInfoSaving) getHibernateTemplate()
					.get("com.legalnod.model.AllStateFormsPaymentInfoSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AllStateFormsPaymentInfoSaving> findByExample(
			AllStateFormsPaymentInfoSaving instance) {
		LOGGER.debug("finding AllStateFormsPaymentInfoSaving instance by example");
		try {
			List<AllStateFormsPaymentInfoSaving> results = (List<AllStateFormsPaymentInfoSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AllStateFormsPaymentInfoSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AllStateFormsPaymentInfoSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AllStateFormsPaymentInfoSaving> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<AllStateFormsPaymentInfoSaving> findByFormName(Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<AllStateFormsPaymentInfoSaving> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<AllStateFormsPaymentInfoSaving> findByUserChoice(
			Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List<AllStateFormsPaymentInfoSaving> findByProcessingFee(
			Object processingFee) {
		return findByProperty(PROCESSING_FEE, processingFee);
	}

	public List<AllStateFormsPaymentInfoSaving> findByStandardFilingFee(
			Object standardFilingFee) {
		return findByProperty(STANDARD_FILING_FEE, standardFilingFee);
	}

	public List<AllStateFormsPaymentInfoSaving> findByTotalFee(Object totalFee) {
		return findByProperty(TOTAL_FEE, totalFee);
	}

	public List<AllStateFormsPaymentInfoSaving> findByTypeOfDocument(
			Object typeOfDocument) {
		return findByProperty(TYPE_OF_DOCUMENT, typeOfDocument);
	}

	public List<AllStateFormsPaymentInfoSaving> findByAddToCart(Object addToCart) {
		return findByProperty(ADD_TO_CART, addToCart);
	}

	public List<AllStateFormsPaymentInfoSaving> findByFormFedStatus(
			Object formFedStatus) {
		return findByProperty(FORM_FED_STATUS, formFedStatus);
	}

	public List<AllStateFormsPaymentInfoSaving> findByRegisteredAgentPrice(
			Object registeredAgentPrice) {
		return findByProperty(REGISTERED_AGENT_PRICE, registeredAgentPrice);
	}

	public List findAll() {
		LOGGER.debug("finding all AllStateFormsPaymentInfoSaving instances");
		try {
			String queryString = "from AllStateFormsPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AllStateFormsPaymentInfoSaving merge(
			AllStateFormsPaymentInfoSaving detachedInstance) {
		LOGGER.debug("merging AllStateFormsPaymentInfoSaving instance");
		try {
			AllStateFormsPaymentInfoSaving result = (AllStateFormsPaymentInfoSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AllStateFormsPaymentInfoSaving instance) {
		LOGGER.debug("attaching dirty AllStateFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AllStateFormsPaymentInfoSaving instance) {
		LOGGER.debug("attaching clean AllStateFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AllStateFormsPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AllStateFormsPaymentInfoSavingDAOImpl) ctx
				.getBean("AllStateFormsPaymentInfoSavingDAO");
	}
}