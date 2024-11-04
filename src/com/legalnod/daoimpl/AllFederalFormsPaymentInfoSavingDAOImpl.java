package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AllFederalFormsPaymentInfoSaving;

/**
 * A data access object (DAO) providing persistence and search support for
 * AllFederalFormsPaymentInfoSaving entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AllFederalFormsPaymentInfoSaving
 * @author MyEclipse Persistence Tools
 */

public class AllFederalFormsPaymentInfoSavingDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AllFederalFormsPaymentInfoSavingDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String LEGAL_NAME = "legalName";
	public static final String TYPE_OF_DOCUMENT = "typeOfDocument";
	public static final String PROCESSING_FEE = "processingFee";
	public static final String TOTAL_FEE = "totalFee";
	public static final String ADD_TO_CART = "addToCart";

	protected void initDao() {
		// do nothing
	}
	

//	All Federal Forms Payment Info Saving Verification
	
	public List allFederalFormsPaymentRowVerification(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllFederalFormsPaymentInfoSaving instance with property: "
				+ userName);
		try {
			String queryString = "from AllFederalFormsPaymentInfoSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and legalName = '"+userChoice+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All Federal Forms Payment Info Modification Verification
	
	public AllFederalFormsPaymentInfoSaving allFederalFormsPaymentModificationVerification(String userName, String typeOfDocument, String userChoice) {
		LOGGER.debug("finding AllFederalFormsPaymentInfoSaving instance with property: ");		
		try {
			String queryString = "from AllFederalFormsPaymentInfoSaving WHERE userName = '"+userName+"' and typeOfDocument = '"+typeOfDocument+"' and legalName = '"+userChoice+"' ";
			return (AllFederalFormsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void save(AllFederalFormsPaymentInfoSaving transientInstance) {
		LOGGER.debug("saving AllFederalFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(AllFederalFormsPaymentInfoSaving persistentInstance) {
		LOGGER.debug("deleting AllFederalFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AllFederalFormsPaymentInfoSaving findById(java.lang.Integer id) {
		LOGGER.debug("getting AllFederalFormsPaymentInfoSaving instance with id: "
				+ id);
		try {
			AllFederalFormsPaymentInfoSaving instance = (AllFederalFormsPaymentInfoSaving) getHibernateTemplate()
					.get("com.legalnod.model.AllFederalFormsPaymentInfoSaving",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AllFederalFormsPaymentInfoSaving> findByExample(
			AllFederalFormsPaymentInfoSaving instance) {
		LOGGER.debug("finding AllFederalFormsPaymentInfoSaving instance by example");
		try {
			List<AllFederalFormsPaymentInfoSaving> results = (List<AllFederalFormsPaymentInfoSaving>) getHibernateTemplate()
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
		LOGGER.debug("finding AllFederalFormsPaymentInfoSaving instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AllFederalFormsPaymentInfoSaving as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AllFederalFormsPaymentInfoSaving> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<AllFederalFormsPaymentInfoSaving> findByLegalName(
			Object legalName) {
		return findByProperty(LEGAL_NAME, legalName);
	}

	public List<AllFederalFormsPaymentInfoSaving> findByTypeOfDocument(
			Object typeOfDocument) {
		return findByProperty(TYPE_OF_DOCUMENT, typeOfDocument);
	}

	public List<AllFederalFormsPaymentInfoSaving> findByProcessingFee(
			Object processingFee) {
		return findByProperty(PROCESSING_FEE, processingFee);
	}

	public List<AllFederalFormsPaymentInfoSaving> findByTotalFee(Object totalFee) {
		return findByProperty(TOTAL_FEE, totalFee);
	}

	public List<AllFederalFormsPaymentInfoSaving> findByAddToCart(
			Object addToCart) {
		return findByProperty(ADD_TO_CART, addToCart);
	}

	public List findAll() {
		LOGGER.debug("finding all AllFederalFormsPaymentInfoSaving instances");
		try {
			String queryString = "from AllFederalFormsPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AllFederalFormsPaymentInfoSaving merge(
			AllFederalFormsPaymentInfoSaving detachedInstance) {
		LOGGER.debug("merging AllFederalFormsPaymentInfoSaving instance");
		try {
			AllFederalFormsPaymentInfoSaving result = (AllFederalFormsPaymentInfoSaving) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AllFederalFormsPaymentInfoSaving instance) {
		LOGGER.debug("attaching dirty AllFederalFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AllFederalFormsPaymentInfoSaving instance) {
		LOGGER.debug("attaching clean AllFederalFormsPaymentInfoSaving instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AllFederalFormsPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AllFederalFormsPaymentInfoSavingDAOImpl) ctx
				.getBean("AllFederalFormsPaymentInfoSavingDAO");
	}
}