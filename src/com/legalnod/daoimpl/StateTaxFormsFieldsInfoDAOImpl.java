package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.StateTaxFormsFieldsInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * StateTaxFormsFieldsInfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.StateTaxFormsFieldsInfo
 * @author MyEclipse Persistence Tools
 */

public class StateTaxFormsFieldsInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StateTaxFormsFieldsInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String ATTRIBUTE_VALUE = "attributeValue";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}

	public void save(StateTaxFormsFieldsInfo transientInstance) {
		LOGGER.debug("saving StateTaxFormsFieldsInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(StateTaxFormsFieldsInfo persistentInstance) {
		LOGGER.debug("deleting StateTaxFormsFieldsInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public StateTaxFormsFieldsInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting StateTaxFormsFieldsInfo instance with id: " + id);
		try {
			StateTaxFormsFieldsInfo instance = (StateTaxFormsFieldsInfo) getHibernateTemplate()
					.get("com.legalnod.model.StateTaxFormsFieldsInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<StateTaxFormsFieldsInfo> findByExample(
			StateTaxFormsFieldsInfo instance) {
		LOGGER.debug("finding StateTaxFormsFieldsInfo instance by example");
		try {
			List<StateTaxFormsFieldsInfo> results = (List<StateTaxFormsFieldsInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding StateTaxFormsFieldsInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StateTaxFormsFieldsInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<StateTaxFormsFieldsInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<StateTaxFormsFieldsInfo> findByAttributeValue(
			Object attributeValue) {
		return findByProperty(ATTRIBUTE_VALUE, attributeValue);
	}

	public List<StateTaxFormsFieldsInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<StateTaxFormsFieldsInfo> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all StateTaxFormsFieldsInfo instances");
		try {
			String queryString = "from StateTaxFormsFieldsInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public StateTaxFormsFieldsInfo merge(
			StateTaxFormsFieldsInfo detachedInstance) {
		LOGGER.debug("merging StateTaxFormsFieldsInfo instance");
		try {
			StateTaxFormsFieldsInfo result = (StateTaxFormsFieldsInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StateTaxFormsFieldsInfo instance) {
		LOGGER.debug("attaching dirty StateTaxFormsFieldsInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StateTaxFormsFieldsInfo instance) {
		LOGGER.debug("attaching clean StateTaxFormsFieldsInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static StateTaxFormsFieldsInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (StateTaxFormsFieldsInfoDAOImpl) ctx
				.getBean("StateTaxFormsFieldsInfoDAO");
	}
}