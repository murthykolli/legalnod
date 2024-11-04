package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.FormFederalDocumentsDataSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * FormFederalDocumentsDataSaving entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.FormFederalDocumentsDataSaving
 * @author MyEclipse Persistence Tools
 */

public class FormFederalDocumentsDataSavingDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FormFederalDocumentsDataSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String LEGAL_NAME = "legalName";
	public static final String FORM_NAME = "formName";
	public static final String STATE_NAME = "stateName";
	public static final String USER_CHOICE = "userChoice";
	public static final String STATUS = "status";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String ADD_TO_CART = "addToCart";
	public static final String PAGE_VARIABLE_REFERENCE = "pageVariableReference";

	protected void initDao() {
		// do nothing
	}

//	Federal Forms UserChoice Take From DB
	public List findByFreeFederalFormsLegalNameFromDB(String userName, String formName, String stateName, String userChoice) {
		logger.debug("finding FormFederalDocumentsDataSaving instance with property: ");		
		try {
			String queryString = "from FormFederalDocumentsDataSaving WHERE userName = '"+userName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Federal Forms UserChoice Take From DB
	public FormFederalDocumentsDataSaving formFederalFormsDataTakeFromDB(String userName, String formName, String stateName, String userChoice, String legalName) {
		logger.debug("finding FormFederalDocumentsDataSaving instance with property: ");		
		try {
			String queryString = "from FormFederalDocumentsDataSaving WHERE userName = '"+userName+"' and legalName = '"+legalName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' and (status = 'In Progress' or status = 'Ready for checkout')";			
			return (FormFederalDocumentsDataSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Already Exit Legal Name in DB DAO IMPL
	
	public List freeFederalFormsAlreadyExittUserChoiceInDB(String userName, String formName, String stateName, String userChoice, String legalName) {
		logger.debug("finding FormFederalDocumentsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "from FormFederalDocumentsDataSaving WHERE userName = '"+userName+"' and legalName = '"+legalName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"'";			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
//	State Forms UserChoice Take From Form Federal DB
	public List stateFormsUserChoiceTakeFromDB(String userName, String formName, String stateName, String userChoice) {
		logger.debug("finding FormFederalDocumentsDataSaving instance with property: ");		
		try {
			String queryString = "from FormFederalDocumentsDataSaving WHERE userName = '"+userName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' and (status = 'In Progress' or status = 'Ready for checkout')";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
	//	State Forms UserChoice Updation in Form Federal DB
	public FormFederalDocumentsDataSaving stateFormsUserChoiceUpdationInFormFedDB(String userName, String formName, String stateName, String userChoice) {
		logger.debug("finding FormFederalDocumentsDataSaving instance with property: ");		
		try {
			String queryString = "from FormFederalDocumentsDataSaving WHERE userName = '"+userName+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' and (status = 'In Progress' or status = 'Ready for checkout')";			
			return (FormFederalDocumentsDataSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//	After Payment Data updating functionality
	
//	Form Federal Checkout Payment Status Update
	
	public int transactionStatusUpdateInFormFederalTable(String userName, String orderStatus) {		
		LOGGER.debug("finding FormFederalDocumentsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "UPDATE FormFederalDocumentsDataSaving set orderStatus = '"+orderStatus+"', addToCart = null WHERE userName = '"+userName+"' and  addToCart = 'Yes' and orderStatus is null";
			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by FormFederalDocumentsDataSaving name failed", re);
			throw re;
		}
	}

	
	public void save(FormFederalDocumentsDataSaving transientInstance) {
		LOGGER.debug("saving FormFederalDocumentsDataSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(FormFederalDocumentsDataSaving persistentInstance) {
		LOGGER.debug("deleting FormFederalDocumentsDataSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public FormFederalDocumentsDataSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting FormFederalDocumentsDataSaving instance with id: "
				+ id);
		try {
			FormFederalDocumentsDataSaving instance = (FormFederalDocumentsDataSaving) getHibernateTemplate()
					.get("com.legalnod.model.FormFederalDocumentsDataSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FormFederalDocumentsDataSaving> findByExample(
			FormFederalDocumentsDataSaving instance) {
		LOGGER.debug("finding FormFederalDocumentsDataSaving instance by example");
		try {
			List<FormFederalDocumentsDataSaving> results = (List<FormFederalDocumentsDataSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding FormFederalDocumentsDataSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FormFederalDocumentsDataSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	After Payment Data updating functionality
	
//	All Form Federal Saving ID take from DB using Add Cart value
	
	public List formFederalSavingAddCartStatusVerificationInDB(String userName) {
		LOGGER.debug("finding FormFederalDocumentsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "from FormFederalDocumentsDataSaving WHERE userName = '"+userName+"' and  addToCart = 'Yes' and orderStatus is null";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by FormFederalDocumentsDataSaving name failed", re);
			throw re;
		}
	}
	
//	All Form Federal Add Cart Value update in DB
	
	public FormFederalDocumentsDataSaving formFederalSavingAddCartStatusUpdateInDB(String userName) {
		LOGGER.debug("finding FormFederalDocumentsDataSaving instance with property: ");		
		try {
			String queryString = "from FormFederalDocumentsDataSaving WHERE userName = '"+userName+"' and  addToCart = 'Yes' and orderStatus is null";
			return (FormFederalDocumentsDataSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FormFederalDocumentsDataSaving> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<FormFederalDocumentsDataSaving> findByLegalName(Object legalName) {
		return findByProperty(LEGAL_NAME, legalName);
	}

	public List<FormFederalDocumentsDataSaving> findByFormName(Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<FormFederalDocumentsDataSaving> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<FormFederalDocumentsDataSaving> findByUserChoice(
			Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List<FormFederalDocumentsDataSaving> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<FormFederalDocumentsDataSaving> findByOrderStatus(
			Object orderStatus) {
		return findByProperty(ORDER_STATUS, orderStatus);
	}

	public List<FormFederalDocumentsDataSaving> findByAddToCart(Object addToCart) {
		return findByProperty(ADD_TO_CART, addToCart);
	}

	public List<FormFederalDocumentsDataSaving> findByPageVariableReference(
			Object pageVariableReference) {
		return findByProperty(PAGE_VARIABLE_REFERENCE, pageVariableReference);
	}

	public List findAll() {
		LOGGER.debug("finding all FormFederalDocumentsDataSaving instances");
		try {
			String queryString = "from FormFederalDocumentsDataSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FormFederalDocumentsDataSaving merge(
			FormFederalDocumentsDataSaving detachedInstance) {
		LOGGER.debug("merging FormFederalDocumentsDataSaving instance");
		try {
			FormFederalDocumentsDataSaving result = (FormFederalDocumentsDataSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FormFederalDocumentsDataSaving instance) {
		LOGGER.debug("attaching dirty FormFederalDocumentsDataSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FormFederalDocumentsDataSaving instance) {
		LOGGER.debug("attaching clean FormFederalDocumentsDataSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FormFederalDocumentsDataSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FormFederalDocumentsDataSavingDAOImpl) ctx
				.getBean("FormFederalDocumentsDataSavingDAO");
	}
}