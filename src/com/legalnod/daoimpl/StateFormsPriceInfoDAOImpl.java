package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.StateFormsPriceInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * StateFormsPriceInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.StateFormsPriceInfo
 * @author MyEclipse Persistence Tools
 */

public class StateFormsPriceInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StateFormsPriceInfoDAOImpl.class);
	// property constants
	public static final String TYPE_OF_FEES = "typeOfFees";
	public static final String FORM_NAME = "formName";
	public static final String STATE = "state";
	public static final String PRICE = "price";
	public static final String COMMENTS = "comments";
	public static final String NO_OF_PARTNERS = "noOfPartners";
	public static final String MAXIMUM_PRICE = "maximumPrice";
	public static final String MINIMUM_PRICE = "minimumPrice";
	public static final String FLAG = "flag";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String CROSS_CHECKING_STATUS = "crossCheckingStatus";

	protected void initDao() {
		// do nothing
	}

//	All State forms price List take from DB
	
	public List allStateFormsPriceListTakeFromDB(int formId) {
		LOGGER.debug("finding StateFormsPriceInfo instance with Form Id: "+ formId );
		try {
			String queryString = "select price from StateFormsPriceInfo WHERE forms = \'" + formId + "\' order by typeOfFees ASC";
			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	All State forms price List take from DB
	
	public List allStateAndDocFormsPriceListTakeFromDB(int formId) {
		LOGGER.debug("finding StateFormsPriceInfo instance with Form Id: "+ formId );
		try {
			String queryString = "from StateFormsPriceInfo WHERE forms = \'" + formId + "\' order by typeOfFees ASC";
			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void save(StateFormsPriceInfo transientInstance) {
		LOGGER.debug("saving StateFormsPriceInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(StateFormsPriceInfo persistentInstance) {
		LOGGER.debug("deleting StateFormsPriceInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public StateFormsPriceInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting StateFormsPriceInfo instance with id: " + id);
		try {
			StateFormsPriceInfo instance = (StateFormsPriceInfo) getHibernateTemplate()
					.get("com.legalnod.model.StateFormsPriceInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<StateFormsPriceInfo> findByExample(StateFormsPriceInfo instance) {
		LOGGER.debug("finding StateFormsPriceInfo instance by example");
		try {
			List<StateFormsPriceInfo> results = (List<StateFormsPriceInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding StateFormsPriceInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StateFormsPriceInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<StateFormsPriceInfo> findByTypeOfFees(Object typeOfFees) {
		return findByProperty(TYPE_OF_FEES, typeOfFees);
	}

	public List<StateFormsPriceInfo> findByFormName(Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<StateFormsPriceInfo> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<StateFormsPriceInfo> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<StateFormsPriceInfo> findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List<StateFormsPriceInfo> findByNoOfPartners(Object noOfPartners) {
		return findByProperty(NO_OF_PARTNERS, noOfPartners);
	}

	public List<StateFormsPriceInfo> findByMaximumPrice(Object maximumPrice) {
		return findByProperty(MAXIMUM_PRICE, maximumPrice);
	}

	public List<StateFormsPriceInfo> findByMinimumPrice(Object minimumPrice) {
		return findByProperty(MINIMUM_PRICE, minimumPrice);
	}

	public List<StateFormsPriceInfo> findByFlag(Object flag) {
		return findByProperty(FLAG, flag);
	}

	public List<StateFormsPriceInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<StateFormsPriceInfo> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List<StateFormsPriceInfo> findByCrossCheckingStatus(
			Object crossCheckingStatus) {
		return findByProperty(CROSS_CHECKING_STATUS, crossCheckingStatus);
	}

	public List findAll() {
		LOGGER.debug("finding all StateFormsPriceInfo instances");
		try {
			String queryString = "from StateFormsPriceInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public StateFormsPriceInfo merge(StateFormsPriceInfo detachedInstance) {
		LOGGER.debug("merging StateFormsPriceInfo instance");
		try {
			StateFormsPriceInfo result = (StateFormsPriceInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StateFormsPriceInfo instance) {
		LOGGER.debug("attaching dirty StateFormsPriceInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StateFormsPriceInfo instance) {
		LOGGER.debug("attaching clean StateFormsPriceInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static StateFormsPriceInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (StateFormsPriceInfoDAOImpl) ctx.getBean("StateFormsPriceInfoDAO");
	}
}