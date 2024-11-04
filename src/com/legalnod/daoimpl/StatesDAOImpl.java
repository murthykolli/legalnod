package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.States;

/**
 * A data access object (DAO) providing persistence and search support for
 * States entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.legalnod.model.States
 * @author MyEclipse Persistence Tools
 */

public class StatesDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(StatesDAOImpl.class);
	// property constants
	public static final String STATE_CODE = "stateCode";
	public static final String STATE_NAME = "stateName";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}

	public void save(States transientInstance) {
		LOGGER.debug("saving States instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(States persistentInstance) {
		LOGGER.debug("deleting States instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public States findById(java.lang.Integer id) {
		LOGGER.debug("getting States instance with id: " + id);
		try {
			States instance = (States) getHibernateTemplate().get(
					"com.legalnod.model.States", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	public List findByStateList() {
		LOGGER.debug("finding States instance with property: ");
		try {
			String queryString = "from States order by stateId ASC";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by States name failed", re);
			throw re;
		}
	}

	public List<States> findByExample(States instance) {
		LOGGER.debug("finding States instance by example");
		try {
			List<States> results = (List<States>) getHibernateTemplate()
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
		LOGGER.debug("finding States instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from States as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<States> findByStateCode(Object stateCode) {
		return findByProperty(STATE_CODE, stateCode);
	}

	public List<States> findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List<States> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<States> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all States instances");
		try {
			String queryString = "from States";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public States merge(States detachedInstance) {
		LOGGER.debug("merging States instance");
		try {
			States result = (States) getHibernateTemplate().merge(
					detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(States instance) {
		LOGGER.debug("attaching dirty States instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(States instance) {
		LOGGER.debug("attaching clean States instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static StatesDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (StatesDAOImpl) ctx.getBean("StatesDAO");
	}
}