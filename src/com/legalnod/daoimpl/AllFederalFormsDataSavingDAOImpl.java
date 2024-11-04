package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AllFederalFormsDataSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AllFederalFormsDataSaving entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AllFederalFormsDataSaving
 * @author MyEclipse Persistence Tools
 */

public class AllFederalFormsDataSavingDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AllFederalFormsDataSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String TYPE_OF_DOCUMENT = "typeOfDocument";
	public static final String DOCUMENT_NAME = "documentName";
	public static final String STATUS = "status";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String ORDER_NUMBER = "orderNumber";
	public static final String ADD_TO_CART = "addToCart";
	public static final String PAGE_VARIABLE_REFERENCE = "pageVariableReference";

	protected void initDao() {
		// do nothing
	}

//	Federal Forms UserChoice Take From DB
	public List findByallFederalFormsUserChoiceFromDB(String userName, String typeOfDocument, String formStatus) {
		logger.debug("finding AllFederalFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and status = '"+formStatus+"' and orderStatus is null";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AllFederalFormsDataSaving findByallFederalFormsDataFromDB(String userName, String typeOfDocument, String userChoice) {
		logger.debug("finding AllFederalFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and documentName = '"+userChoice+"' and (status = 'In Progress' or status = 'Ready for checkout')";
			return (AllFederalFormsDataSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Already Exit user choice in DB DAO IMPL
	
	public List allFederalFormsAlreadyExittUserChoiceInDB(String userName, String typeOfDocument, String userChoice) {
		logger.debug("finding AllFederalFormsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllFederalFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and documentName = '"+userChoice+"' and status != 'Deleted'";			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Checkout Payment Data DAO IMPL
	
	public List allFederalFormsCheckoutUserChoiceInDB(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllFederalFormsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllFederalFormsDataSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and documentName = '"+userChoice+"' and (status = 'In Progress' or status = 'Ready for checkout')";			
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List federalFormsSavingDataTakeFromDB(String userName) {
		LOGGER.debug("finding AllFederalFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsDataSaving WHERE userName = '"+userName+"' and (status = 'In Progress' or status = 'Ready for checkout') and orderStatus is null order by createdDate DESC nulls last, modifiedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	//Completed State Forms For User Data Display DAO Implementation
	
	public List completedFederalFormsForUSerDataFromDB(String userName) {
		LOGGER.debug("finding AllFederalFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsDataSaving WHERE userName = '"+userName+"' and (status = 'In Progress' or status = 'Ready for checkout') and orderStatus is not null and orderNumber is not null order by orderNumberDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	//Edit User profile Federal Forms For User Data Display DAO Implementation
	public List editUPFederalFormsSavingDataTakeFromDB(String userName) {
		LOGGER.debug("finding AllFederalFormsDataSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsDataSaving WHERE userName = '"+userName+"' and (status = 'In Progress' or status = 'Ready for checkout') order by createdDate DESC nulls last, modifiedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//	After Payment Data updating functionality
	
//	All Federal Forms Saving Table Update
	
	public int transactionStatusUpdateInFederalFormsSavingTable(String userName, String orderStatus) {		
		LOGGER.debug("finding AllFederalFormsDataSaving instance with property: "
				+ userName);
		try {
			String queryString = "UPDATE AllFederalFormsDataSaving set orderStatus = '"+orderStatus+"', addToCart = null WHERE userName = '"+userName+"' and  addToCart = 'Yes' and orderStatus is null";
			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllFederalFormsDataSaving name failed", re);
			throw re;
		}
	}
		
	public void save(AllFederalFormsDataSaving transientInstance) {
		LOGGER.debug("saving AllFederalFormsDataSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(AllFederalFormsDataSaving persistentInstance) {
		LOGGER.debug("deleting AllFederalFormsDataSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AllFederalFormsDataSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting AllFederalFormsDataSaving instance with id: " + id);
		try {
			AllFederalFormsDataSaving instance = (AllFederalFormsDataSaving) getHibernateTemplate()
					.get("com.legalnod.model.AllFederalFormsDataSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AllFederalFormsDataSaving> findByExample(
			AllFederalFormsDataSaving instance) {
		LOGGER.debug("finding AllFederalFormsDataSaving instance by example");
		try {
			List<AllFederalFormsDataSaving> results = (List<AllFederalFormsDataSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AllFederalFormsDataSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AllFederalFormsDataSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AllFederalFormsDataSaving> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<AllFederalFormsDataSaving> findByTypeOfDocument(
			Object typeOfDocument) {
		return findByProperty(TYPE_OF_DOCUMENT, typeOfDocument);
	}

	public List<AllFederalFormsDataSaving> findByDocumentName(
			Object documentName) {
		return findByProperty(DOCUMENT_NAME, documentName);
	}

	public List<AllFederalFormsDataSaving> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<AllFederalFormsDataSaving> findByOrderStatus(Object orderStatus) {
		return findByProperty(ORDER_STATUS, orderStatus);
	}

	public List<AllFederalFormsDataSaving> findByOrderNumber(Object orderNumber) {
		return findByProperty(ORDER_NUMBER, orderNumber);
	}

	public List<AllFederalFormsDataSaving> findByAddToCart(Object addToCart) {
		return findByProperty(ADD_TO_CART, addToCart);
	}

	public List<AllFederalFormsDataSaving> findByPageVariableReference(
			Object pageVariableReference) {
		return findByProperty(PAGE_VARIABLE_REFERENCE, pageVariableReference);
	}

	public List findAll() {
		LOGGER.debug("finding all AllFederalFormsDataSaving instances");
		try {
			String queryString = "from AllFederalFormsDataSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AllFederalFormsDataSaving merge(
			AllFederalFormsDataSaving detachedInstance) {
		LOGGER.debug("merging AllFederalFormsDataSaving instance");
		try {
			AllFederalFormsDataSaving result = (AllFederalFormsDataSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AllFederalFormsDataSaving instance) {
		LOGGER.debug("attaching dirty AllFederalFormsDataSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AllFederalFormsDataSaving instance) {
		LOGGER.debug("attaching clean AllFederalFormsDataSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AllFederalFormsDataSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AllFederalFormsDataSavingDAOImpl) ctx
				.getBean("AllFederalFormsDataSavingDAO");
	}
}