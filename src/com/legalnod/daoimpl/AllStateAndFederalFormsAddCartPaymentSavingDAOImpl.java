package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AllStateAndFederalFormsAddCartPaymentSaving entities. Transaction control of
 * the save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving
 * @author MyEclipse Persistence Tools
 */

public class AllStateAndFederalFormsAddCartPaymentSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AllStateAndFederalFormsAddCartPaymentSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String SELECTED_DOCUMENTS_NAME = "selectedDocumentsName";
	public static final String TYPE_OF_DOCUMENT = "typeOfDocument";
	public static final String AMOUNT = "amount";
	public static final String ADD_TO_CART = "addToCart";
	public static final String RESPONSE_REASON_TEXT = "responseReasonText";
	public static final String PAYMENT_ID = "paymentId";
	public static final String DOCUMENT_REF_TYPE = "documentRefType";
	public static final String FORM_NAME = "formName";
	public static final String STATE_NAME = "stateName";
	public static final String USER_CHOICE = "userChoice";

	protected void initDao() {
		// do nothing
	}

//	All State And Federal Forms Add Cart Payment Data Take From Data Base
	
	public List allStateAndFederalFormsAddCartPaymentDataTakeFromDB(String userName) {
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance with userName: "
				+ userName );
		try {
			String queryString = "from AllStateAndFederalFormsAddCartPaymentSaving where userName = '"+userName+"' and addToCart = 'Yes' and responseReasonText is null order by createdDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All State Forms Add Cart Payment Info updating
	
	public List allStateAndFederalFormsAddCartPaymentDataUpdateInDB(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllStateAndFederalFormsAddCartPaymentSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All Federal Forms Add Cart Payment Info updating
	
	public List allOnlyFederalFormsAddCartPaymentDataUpdateInDB(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllStateAndFederalFormsAddCartPaymentSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and selectedDocumentsName = '"+userChoice+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

//	All State Forms Add Cart Payment Info deleted values reference
	
	public AllStateAndFederalFormsAddCartPaymentSaving allStateFormsDataDeleteFromCart(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance with property: ");		
		try {
			String queryString = "from AllStateAndFederalFormsAddCartPaymentSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"' ";
			return (AllStateAndFederalFormsAddCartPaymentSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All Federal Forms Add Cart Payment Info deleted values reference
	
	public AllStateAndFederalFormsAddCartPaymentSaving allFederalFormsDataDeleteFromCart(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance with property: ");		
		try {
			String queryString = "from AllStateAndFederalFormsAddCartPaymentSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and selectedDocumentsName = '"+userChoice+"' ";
			return (AllStateAndFederalFormsAddCartPaymentSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	After Checkout Payment Add Cart delete Functionality	
//	All State and Federal Forms Add Cart Payment Info delete
	
	public int stateAndFederalFormsAddCartPaymentDeletion(String userName) {		
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance with property: "
				+ userName);
		try {
			String queryString = "DELETE AllStateAndFederalFormsAddCartPaymentSaving WHERE userName = '"+userName+"' and  addToCart = 'Yes'";
			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllStateAndFederalFormsAddCartPaymentSaving name failed", re);
			throw re;
		}
	}
	
	public void save(
			AllStateAndFederalFormsAddCartPaymentSaving transientInstance) {
		LOGGER.debug("saving AllStateAndFederalFormsAddCartPaymentSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(
			AllStateAndFederalFormsAddCartPaymentSaving persistentInstance) {
		LOGGER.debug("deleting AllStateAndFederalFormsAddCartPaymentSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AllStateAndFederalFormsAddCartPaymentSaving findById(
			java.lang.Integer id) {
		LOGGER.debug("getting AllStateAndFederalFormsAddCartPaymentSaving instance with id: "
				+ id);
		try {
			AllStateAndFederalFormsAddCartPaymentSaving instance = (AllStateAndFederalFormsAddCartPaymentSaving) getHibernateTemplate()
					.get("com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByExample(
			AllStateAndFederalFormsAddCartPaymentSaving instance) {
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance by example");
		try {
			List<AllStateAndFederalFormsAddCartPaymentSaving> results = (List<AllStateAndFederalFormsAddCartPaymentSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AllStateAndFederalFormsAddCartPaymentSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AllStateAndFederalFormsAddCartPaymentSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByUserName(
			Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findBySelectedDocumentsName(
			Object selectedDocumentsName) {
		return findByProperty(SELECTED_DOCUMENTS_NAME, selectedDocumentsName);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByTypeOfDocument(
			Object typeOfDocument) {
		return findByProperty(TYPE_OF_DOCUMENT, typeOfDocument);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByAmount(
			Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByAddToCart(
			Object addToCart) {
		return findByProperty(ADD_TO_CART, addToCart);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByResponseReasonText(
			Object responseReasonText) {
		return findByProperty(RESPONSE_REASON_TEXT, responseReasonText);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByPaymentId(
			Object paymentId) {
		return findByProperty(PAYMENT_ID, paymentId);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByDocumentRefType(
			Object documentRefType) {
		return findByProperty(DOCUMENT_REF_TYPE, documentRefType);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByFormName(
			Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByStateName(
			Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<AllStateAndFederalFormsAddCartPaymentSaving> findByUserChoice(
			Object userChoice) {
		return findByProperty(USER_CHOICE, userChoice);
	}

	public List findAll() {
		LOGGER.debug("finding all AllStateAndFederalFormsAddCartPaymentSaving instances");
		try {
			String queryString = "from AllStateAndFederalFormsAddCartPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AllStateAndFederalFormsAddCartPaymentSaving merge(
			AllStateAndFederalFormsAddCartPaymentSaving detachedInstance) {
		LOGGER.debug("merging AllStateAndFederalFormsAddCartPaymentSaving instance");
		try {
			AllStateAndFederalFormsAddCartPaymentSaving result = (AllStateAndFederalFormsAddCartPaymentSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AllStateAndFederalFormsAddCartPaymentSaving instance) {
		LOGGER.debug("attaching dirty AllStateAndFederalFormsAddCartPaymentSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AllStateAndFederalFormsAddCartPaymentSaving instance) {
		LOGGER.debug("attaching clean AllStateAndFederalFormsAddCartPaymentSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AllStateAndFederalFormsAddCartPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AllStateAndFederalFormsAddCartPaymentSavingDAOImpl) ctx
				.getBean("AllStateAndFederalFormsAddCartPaymentSavingDAO");
	}
}