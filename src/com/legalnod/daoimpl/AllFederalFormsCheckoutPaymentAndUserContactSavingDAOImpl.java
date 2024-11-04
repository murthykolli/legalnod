package com.legalnod.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AllFederalFormsCheckoutPaymentAndUserContactSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AllFederalFormsCheckoutPaymentAndUserContactSaving entities. Transaction
 * control of the save(), update() and delete() operations can directly support
 * Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AllFederalFormsCheckoutPaymentAndUserContactSaving
 * @author MyEclipse Persistence Tools
 */

public class AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl extends
		HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl.class);
	// property constants
	
	protected void initDao() {
		// do nothing
	}
	
//	All Federal Forms Checkout Payment Info Saving Verification
	
	public List allFederalFormsCheckoutPaymentRowVerification(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and formStatus = '"+typeOfDocument+"' and legalName = '"+userChoice+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All Federal Forms Checkout Payment Info values take from DB using Payment ID
	
	public List allFederalFormsCheckoutPaymentValuesTakeFromDB(int paymentID) {
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ paymentID);
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving where allFederalFormsCheckoutPaymentAndUserContactSavingId = '"+paymentID+"' ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllFederalFormsCheckoutPaymentAndUserContactSaving name failed", re);
			throw re;
		}
	}
	
//	All Federal Forms Checkout Payment Info deleted values reference
	
	public AllFederalFormsCheckoutPaymentAndUserContactSaving allFederalFormsCheckoutPaymentDataDeleteFromCart(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and formStatus = '"+typeOfDocument+"' and legalName = '"+userChoice+"' ";
			return (AllFederalFormsCheckoutPaymentAndUserContactSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Completed Federal forms for Admin DAO Impl
	
	public List completedFederalFormsForAdminDataFromDB(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and formStatus = '"+typeOfDocument+"' and legalName = '"+userChoice+"' and responseReasonText is not null and invoiceNum is not null order by createdDate DESC nulls last, modifiedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//	After Payment Data updating functionality
	
//	All Federal Forms Checkout Payment Status Update
	
	public int transactionStatusUpdateInFederalFormsPaymentContTable(String userName, String orderStatus, int userPaymentTranId) {		
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ userName);
		java.util.Date date = new java.util.Date();
		Timestamp currentDate = new Timestamp(date.getTime());
		try {
			String queryString = "UPDATE AllFederalFormsCheckoutPaymentAndUserContactSaving set responseReasonText = '"+orderStatus+"', userPaymentTransactionInfoSavingId = '"+userPaymentTranId+"', " +
					"addToCart = null, orderReceived  = 'Done', orderReceivedCreatedDate = '"+currentDate+"' " +
					"WHERE userName = '"+userName+"' and  addToCart = 'Yes' and responseReasonText is null";
			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllFederalFormsCheckoutPaymentAndUserContactSaving name failed", re);
			throw re;
		}
	}
	
	
	
	public void save(
			AllFederalFormsCheckoutPaymentAndUserContactSaving transientInstance) {
		LOGGER.debug("saving AllFederalFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(
			AllFederalFormsCheckoutPaymentAndUserContactSaving persistentInstance) {
		LOGGER.debug("deleting AllFederalFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AllFederalFormsCheckoutPaymentAndUserContactSaving findById(
			java.lang.Integer id) {
		LOGGER.debug("getting AllFederalFormsCheckoutPaymentAndUserContactSaving instance with id: "
				+ id);
		try {
			AllFederalFormsCheckoutPaymentAndUserContactSaving instance = (AllFederalFormsCheckoutPaymentAndUserContactSaving) getHibernateTemplate()
					.get("com.legalnod.model.AllFederalFormsCheckoutPaymentAndUserContactSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AllFederalFormsCheckoutPaymentAndUserContactSaving> findByExample(
			AllFederalFormsCheckoutPaymentAndUserContactSaving instance) {
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance by example");
		try {
			List<AllFederalFormsCheckoutPaymentAndUserContactSaving> results = (List<AllFederalFormsCheckoutPaymentAndUserContactSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	

//	After Payment Data updating functionality
	
//	All Federal Forms Checkout Payment ID take from DB using Add Cart value
	
	public List federalFormsCheckoutPaymentIdVerificationInDB(String userName) {
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and  addToCart = 'Yes' and responseReasonText is null";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AllFederalFormsCheckoutPaymentAndUserContactSaving name failed", re);
			throw re;
		}
	}
	
//	All Federal Forms Checkout Payment Contact Info Data update in DB Using Add Cart Value
	
	public AllFederalFormsCheckoutPaymentAndUserContactSaving federalFormsCheckoutPaymentContactInfoUpdateInDB(String userName) {
		LOGGER.debug("finding AllFederalFormsCheckoutPaymentAndUserContactSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving WHERE userName = '"+userName+"' and  addToCart = 'Yes' and responseReasonText is null";
			return (AllFederalFormsCheckoutPaymentAndUserContactSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		LOGGER.debug("finding all AllFederalFormsCheckoutPaymentAndUserContactSaving instances");
		try {
			String queryString = "from AllFederalFormsCheckoutPaymentAndUserContactSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AllFederalFormsCheckoutPaymentAndUserContactSaving merge(
			AllFederalFormsCheckoutPaymentAndUserContactSaving detachedInstance) {
		LOGGER.debug("merging AllFederalFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			AllFederalFormsCheckoutPaymentAndUserContactSaving result = (AllFederalFormsCheckoutPaymentAndUserContactSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(
			AllFederalFormsCheckoutPaymentAndUserContactSaving instance) {
		LOGGER.debug("attaching dirty AllFederalFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(
			AllFederalFormsCheckoutPaymentAndUserContactSaving instance) {
		LOGGER.debug("attaching clean AllFederalFormsCheckoutPaymentAndUserContactSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl) ctx
				.getBean("AllFederalFormsCheckoutPaymentAndUserContactSavingDAO");
	}
}