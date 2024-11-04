package com.legalnod.daoimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.UserPaymentTransactionInfoSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * UsersInformation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.UsersInformation
 * @author MyEclipse Persistence Tools
 */

public class UserPaymentTransactionInfoSavingDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserPaymentTransactionInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(UserPaymentTransactionInfoSaving transientInstance) {
		LOGGER.debug("saving UserPaymentTransactionInfoSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
//	All State Forms Checkout Payment Info deleted values reference
	
	public UserPaymentTransactionInfoSaving paymentTransactionIdTakeFromDB(String userName, long transNumber) {
		LOGGER.debug("finding UserPaymentTransactionInfoSaving instance with property: ");		
		try {
			String queryString = "from UserPaymentTransactionInfoSaving WHERE userName = '"+userName+"' and transactionNumber = '"+transNumber+"'";
			return (UserPaymentTransactionInfoSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public void delete(UserPaymentTransactionInfoSaving persistentInstance) {
		LOGGER.debug("deleting UserPaymentTransactionInfoSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}


}
