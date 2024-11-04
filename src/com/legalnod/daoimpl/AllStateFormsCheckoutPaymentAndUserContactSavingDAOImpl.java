package com.legalnod.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AllStateFormsCheckoutPaymentAndUserContactSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AllStateFormsCheckoutPaymentAndUserContactSaving entities. Transaction
 * control of the save(), update() and delete() operations can directly support
 * Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AllStateFormsCheckoutPaymentAndUserContactSaving
 * @author MyEclipse Persistence Tools
 */

public class AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl.class);
	// property constants
	
	protected void initDao() {
		// do nothing
	}
	
//	All State Forms Checkout Payment Info Saving Verification
	
	public List allStateFormsCheckoutPaymentRowVerification(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All State Forms Checkout Payment Info values take from DB using Payment ID
	
	public List allStateFormsCheckoutPaymentValuesTakeFromDB(int paymentID) {
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ paymentID);
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving where allStateFormsCheckoutPaymentAndUserContactSavingId = '"+paymentID+"' ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllStateFormsCheckoutPaymentAndUserContactSaving name failed", re);
			throw re;
		}
	}
	
//	All State Forms Checkout Payment Info deleted values reference
	
	public AllStateFormsCheckoutPaymentAndUserContactSaving allStateFormsCheckoutPaymentDataDeleteFromCart(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"' ";
			return (AllStateFormsCheckoutPaymentAndUserContactSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Free federal legal name checking and update
	
	public List freeFederalLegalNameTakeFromDB(String userName, String typeOfDocument, String stateName, String formName, String userChoice, String legalName) {
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"' and formFedLegalname = '"+legalName+"' ";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Completed state forms for Admin DAO Impl
	
	public List completedStateFormsForAdminDataFromDB(String userName, String formName, String stateName, String userChoice, String typeOfDocument) {
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and stateName = '"+stateName+"' and userChoice = '"+userChoice+"' and responseReasonText is not null and invoiceNum is not null order by createdDate DESC nulls last, modifiedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Free federal legal name checking and update in payment contact info saving table
	
	public List freeFederalLegalNameTakeFromPaymentContactDB(String userName, String typeOfDocument, String stateName, String formName, String userChoice) {
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: ");		
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and formName = '"+formName+"' and userChoice = '"+userChoice+"' and stateName = '"+stateName+"'";
			return getHibernateTemplate().find(queryString);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void save(
			AllStateFormsCheckoutPaymentAndUserContactSaving transientInstance) {
		LOGGER.debug("saving AllStateFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
//	After Payment Data updating functionality
	
//	All State Forms Checkout Payment Status Update
	
	public int transactionStatusUpdateInStateFormsPaymentContTable(String userName, String orderStatus, int userPaymentTranId) {		
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ userName);
		java.util.Date date = new java.util.Date();
		Timestamp currentDate = new Timestamp(date.getTime());
		try {
			String queryString = "UPDATE AllStateFormsCheckoutPaymentAndUserContactSaving set responseReasonText = '"+orderStatus+"', userPaymentTransactionInfoSavingId = '"+userPaymentTranId+"', " +
					"addToCart = null, orderReceived  = 'Done', orderReceivedCreatedDate = '"+currentDate+"' " +
					"WHERE userName = '"+userName+"' and  addToCart = 'Yes' and responseReasonText is null";
			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllStateFormsCheckoutPaymentAndUserContactSaving name failed", re);
			throw re;
		}
	}

	public void delete(
			AllStateFormsCheckoutPaymentAndUserContactSaving persistentInstance) {
		LOGGER.debug("deleting AllStateFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AllStateFormsCheckoutPaymentAndUserContactSaving findById(
			java.lang.Integer id) {
		LOGGER.debug("getting AllStateFormsCheckoutPaymentAndUserContactSaving instance with id: "
				+ id);
		try {
			AllStateFormsCheckoutPaymentAndUserContactSaving instance = (AllStateFormsCheckoutPaymentAndUserContactSaving) getHibernateTemplate()
					.get("com.legalnod.model.AllStateFormsCheckoutPaymentAndUserContactSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AllStateFormsCheckoutPaymentAndUserContactSaving> findByExample(
			AllStateFormsCheckoutPaymentAndUserContactSaving instance) {
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance by example");
		try {
			List<AllStateFormsCheckoutPaymentAndUserContactSaving> results = (List<AllStateFormsCheckoutPaymentAndUserContactSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AllStateFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		LOGGER.debug("finding all AllStateFormsCheckoutPaymentAndUserContactSaving instances");
		try {
			String queryString = "from AllStateFormsCheckoutPaymentAndUserContactSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AllStateFormsCheckoutPaymentAndUserContactSaving merge(
			AllStateFormsCheckoutPaymentAndUserContactSaving detachedInstance) {
		LOGGER.debug("merging AllStateFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			AllStateFormsCheckoutPaymentAndUserContactSaving result = (AllStateFormsCheckoutPaymentAndUserContactSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(
			AllStateFormsCheckoutPaymentAndUserContactSaving instance) {
		LOGGER.debug("attaching dirty AllStateFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(
			AllStateFormsCheckoutPaymentAndUserContactSaving instance) {
		LOGGER.debug("attaching clean AllStateFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl) ctx
				.getBean("AllStateFormsCheckoutPaymentAndUserContactSavingDAO");
	}
}