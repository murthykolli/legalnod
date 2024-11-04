package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.UsersSessionTime;

/**
 * A data access object (DAO) providing persistence and search support for
 * UsersSessionTime entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.UsersSessionTime
 * @author MyEclipse Persistence Tools
 */

public class UsersSessionTimeDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UsersSessionTimeDAOImpl.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String SESSION_TIME = "sessionTime";
	public static final String YEAR = "year";
	public static final String MONTH = "month";
	public static final String WEEK = "week";
	public static final String DAY = "day";

	protected void initDao() {
		// do nothing
	}

	public void save(UsersSessionTime transientInstance) {
		LOGGER.debug("saving UsersSessionTime instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(UsersSessionTime persistentInstance) {
		LOGGER.debug("deleting UsersSessionTime instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public UsersSessionTime findById(java.lang.Integer id) {
		LOGGER.debug("getting UsersSessionTime instance with id: " + id);
		try {
			UsersSessionTime instance = (UsersSessionTime) getHibernateTemplate()
					.get("com.legalnod.model.UsersSessionTime", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<UsersSessionTime> findByExample(UsersSessionTime instance) {
		LOGGER.debug("finding UsersSessionTime instance by example");
		try {
			List<UsersSessionTime> results = (List<UsersSessionTime>) getHibernateTemplate()
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
		LOGGER.debug("finding UsersSessionTime instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UsersSessionTime as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<UsersSessionTime> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<UsersSessionTime> findBySessionTime(Object sessionTime) {
		return findByProperty(SESSION_TIME, sessionTime);
	}

	public List<UsersSessionTime> findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List<UsersSessionTime> findByMonth(Object month) {
		return findByProperty(MONTH, month);
	}

	public List<UsersSessionTime> findByWeek(Object week) {
		return findByProperty(WEEK, week);
	}

	public List<UsersSessionTime> findByDay(Object day) {
		return findByProperty(DAY, day);
	}

	public List findAll() {
		LOGGER.debug("finding all UsersSessionTime instances");
		try {
			String queryString = "from UsersSessionTime";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public UsersSessionTime merge(UsersSessionTime detachedInstance) {
		LOGGER.debug("merging UsersSessionTime instance");
		try {
			UsersSessionTime result = (UsersSessionTime) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UsersSessionTime instance) {
		LOGGER.debug("attaching dirty UsersSessionTime instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UsersSessionTime instance) {
		LOGGER.debug("attaching clean UsersSessionTime instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static UsersSessionTimeDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsersSessionTimeDAOImpl) ctx.getBean("UsersSessionTimeDAO");
	}
}