package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AdditionalFormsFieldsInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdditionalFormsFieldsInfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AdditionalFormsFieldsInfo
 * @author MyEclipse Persistence Tools
 */

public class AdditionalFormsFieldsInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdditionalFormsFieldsInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String ATTRIBUTE_VALUE = "attributeValue";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}

	public void save(AdditionalFormsFieldsInfo transientInstance) {
		LOGGER.debug("saving AdditionalFormsFieldsInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdditionalFormsFieldsInfo persistentInstance) {
		LOGGER.debug("deleting AdditionalFormsFieldsInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AdditionalFormsFieldsInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting AdditionalFormsFieldsInfo instance with id: " + id);
		try {
			AdditionalFormsFieldsInfo instance = (AdditionalFormsFieldsInfo) getHibernateTemplate()
					.get("com.legalnod.model.AdditionalFormsFieldsInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdditionalFormsFieldsInfo> findByExample(
			AdditionalFormsFieldsInfo instance) {
		LOGGER.debug("finding AdditionalFormsFieldsInfo instance by example");
		try {
			List<AdditionalFormsFieldsInfo> results = (List<AdditionalFormsFieldsInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding AdditionalFormsFieldsInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdditionalFormsFieldsInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AdditionalFormsFieldsInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<AdditionalFormsFieldsInfo> findByAttributeValue(
			Object attributeValue) {
		return findByProperty(ATTRIBUTE_VALUE, attributeValue);
	}

	public List<AdditionalFormsFieldsInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<AdditionalFormsFieldsInfo> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all AdditionalFormsFieldsInfo instances");
		try {
			String queryString = "from AdditionalFormsFieldsInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdditionalFormsFieldsInfo merge(
			AdditionalFormsFieldsInfo detachedInstance) {
		LOGGER.debug("merging AdditionalFormsFieldsInfo instance");
		try {
			AdditionalFormsFieldsInfo result = (AdditionalFormsFieldsInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdditionalFormsFieldsInfo instance) {
		LOGGER.debug("attaching dirty AdditionalFormsFieldsInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdditionalFormsFieldsInfo instance) {
		LOGGER.debug("attaching clean AdditionalFormsFieldsInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdditionalFormsFieldsInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdditionalFormsFieldsInfoDAOImpl) ctx
				.getBean("AdditionalFormsFieldsInfoDAO");
	}
}