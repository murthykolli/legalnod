package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AllStateFormsDataSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AllStateFormsDataSaving entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.AllStateFormsDataSaving
 * @author MyEclipse Persistence Tools
 */

public class AllStateFormsDataSavingDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AllStateFormsDataSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String TYPE_OF_DOCUMENT = "typeOfDocument";
	public static final String FORM_NAME = "formName";
	public static final String STATE_NAME = "stateName";
	public static final String USER_CHOICE = "userChoice";
	public static final String STATUS = "status";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String ORDER_NUMBER = "orderNumber";
	public static final String FEDERAL_STATUS = "federalStatus";
	public static final String ADMIN_DELETE_STATUS = "adminDeleteStatus";
	public static final String FORM_STATUS = "formStatus";
	public static final String ADD_TO_CART = "addToCart";
	public static final String REGISTERED_AGENT_PRICE = "registeredAgentPrice";
	public static final String PAGE_VARIABLE_REFERENCE = "pageVariableReference";

	protected void initDao() {
		// do nothing
	}

	public void save(AllStateFormsDataSaving transientInstance) {
		LOGGER.debug("saving AllStateFormsDataSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public AllStateFormsDataSaving findByallStateFormsDataFromDB(String userName, String typeOfDocument, String formName, String stateName, String userChoice) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' and (status = 'In Progress' or status = 'Ready for checkout')";
			return (AllStateFormsDataSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByallStateFormsUserChoiceFromDB(String userName, String typeOfDocument, String formName, String stateName, String formStatus) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and status = '"+formStatus+"' and orderStatus is null";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List stateFormsSavingDataFromDB(String userName) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and (status = 'In Progress' or status = 'Ready for checkout') and orderStatus is null order by createdDate DESC nulls last, modifiedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Completed state forms for user DAO Impl
	
	public List completedStateFormsForUSerDataFromDB(String userName) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and (status = 'In Progress' or status = 'Ready for checkout') and orderStatus is not null and orderNumber is not null order by orderNumberDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Edit user Profile state forms for user DAO Impl
	public List editUPStateFormsSavingDataFromDB(String userName) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and (status = 'In Progress' or status = 'Ready for checkout') order by createdDate DESC nulls last, modifiedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AllStateFormsDataSaving allStateFormsDeletionInDB(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"' and (status = 'In Progress' or status = 'Ready for checkout')";
			return (AllStateFormsDataSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

//	Checkout Payment Data DAO IMPL
	
	public List allStateFormsCheckoutUserChoiceInDB(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"' and (status = 'In Progress' or status = 'Ready for checkout')";			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Already Exit user choice in DB DAO IMPL
	
	public List allStateFormsAlreadyExittUserChoiceInDB(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllStateFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"' and status != 'Deleted'";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	After Payment Data updating functionality
	
//	All State Forms Saving Table Update
	
	public int transactionStatusUpdateInStateFormsSavingTable(String userName, String orderStatus) {		
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "UPDATE AllStateFormsDataSaving set orderStatus = '"+orderStatus+"', addToCart = null WHERE userName = '"+userName+"' and  addToCart = 'Yes' and orderStatus is null";
			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllStateFormsDataSaving name failed", re);
			throw re;
		}
	}
	
	public AllStateFormsDataSaving merge(
			AllStateFormsDataSaving detachedInstance) {
		LOGGER.debug("merging AllStateFormsDataSaving instance");
		try {
			AllStateFormsDataSaving result = (AllStateFormsDataSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void delete(AllStateFormsDataSaving persistentInstance) {
		LOGGER.debug("deleting AllStateFormsDataSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AllStateFormsDataSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting AllStateFormsDataSaving instance with id: " + id);
		try {
			AllStateFormsDataSaving instance = (AllStateFormsDataSaving) getHibernateTemplate()
					.get("com.legalnod.model.AllStateFormsDataSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AllStateFormsDataSaving> findByExample(
			AllStateFormsDataSaving instance) {
		LOGGER.debug("finding AllStateFormsDataSaving instance by example");
		try {
			List<AllStateFormsDataSaving> results = (List<AllStateFormsDataSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AllStateFormsDataSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AllStateFormsDataSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AllStateFormsDataSaving> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<AllStateFormsDataSaving> findByTypeOfDocument(
			Object typeOfDocument) {
		return findByProperty(TYPE_OF_DOCUMENT, typeOfDocument);
	}

	public List<AllStateFormsDataSaving> findByFormName(Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<AllStateFormsDataSaving> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<AllStateFormsDataSaving> findByUserChoice(Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List<AllStateFormsDataSaving> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<AllStateFormsDataSaving> findByOrderStatus(Object orderStatus) {
		return findByProperty(ORDER_STATUS, orderStatus);
	}

	public List<AllStateFormsDataSaving> findByOrderNumber(Object orderNumber) {
		return findByProperty(ORDER_NUMBER, orderNumber);
	}

	public List<AllStateFormsDataSaving> findByFederalStatus(
			Object federalStatus) {
		return findByProperty(FEDERAL_STATUS, federalStatus);
	}

	public List<AllStateFormsDataSaving> findByAdminDeleteStatus(
			Object adminDeleteStatus) {
		return findByProperty(ADMIN_DELETE_STATUS, adminDeleteStatus);
	}

	public List<AllStateFormsDataSaving> findByFormStatus(Object formStatus) {
		return findByProperty(FORM_STATUS, formStatus);
	}

	public List<AllStateFormsDataSaving> findByAddToCart(Object addToCart) {
		return findByProperty(ADD_TO_CART, addToCart);
	}

	public List<AllStateFormsDataSaving> findByRegisteredAgentPrice(
			Object registeredAgentPrice) {
		return findByProperty(REGISTERED_AGENT_PRICE, registeredAgentPrice);
	}

	public List<AllStateFormsDataSaving> findByPageVariableReference(
			Object pageVariableReference) {
		return findByProperty(PAGE_VARIABLE_REFERENCE, pageVariableReference);
	}

	public List findAll() {
		LOGGER.debug("finding all AllStateFormsDataSaving instances");
		try {
			String queryString = "from AllStateFormsDataSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}	

	public void attachDirty(AllStateFormsDataSaving instance) {
		LOGGER.debug("attaching dirty AllStateFormsDataSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AllStateFormsDataSaving instance) {
		LOGGER.debug("attaching clean AllStateFormsDataSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AllStateFormsDataSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AllStateFormsDataSavingDAOImpl) ctx
				.getBean("AllStateFormsDataSavingDAO");
	}
}