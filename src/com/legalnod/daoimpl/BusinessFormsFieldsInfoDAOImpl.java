package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.BusinessFormsFieldsInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * BusinessFormsFieldsInfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.BusinessFormsFieldsInfo
 * @author MyEclipse Persistence Tools
 */

public class BusinessFormsFieldsInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BusinessFormsFieldsInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String ATTRIBUTE_VALUE = "attributeValue";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}

	public void save(BusinessFormsFieldsInfo transientInstance) {
		LOGGER.debug("saving BusinessFormsFieldsInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(BusinessFormsFieldsInfo persistentInstance) {
		LOGGER.debug("deleting BusinessFormsFieldsInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public BusinessFormsFieldsInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting BusinessFormsFieldsInfo instance with id: " + id);
		try {
			BusinessFormsFieldsInfo instance = (BusinessFormsFieldsInfo) getHibernateTemplate()
					.get("com.legalnod.model.BusinessFormsFieldsInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<BusinessFormsFieldsInfo> findByExample(
			BusinessFormsFieldsInfo instance) {
		LOGGER.debug("finding BusinessFormsFieldsInfo instance by example");
		try {
			List<BusinessFormsFieldsInfo> results = (List<BusinessFormsFieldsInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding BusinessFormsFieldsInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BusinessFormsFieldsInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BusinessFormsFieldsInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<BusinessFormsFieldsInfo> findByAttributeValue(
			Object attributeValue) {
		return findByProperty(ATTRIBUTE_VALUE, attributeValue);
	}

	public List<BusinessFormsFieldsInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<BusinessFormsFieldsInfo> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all BusinessFormsFieldsInfo instances");
		try {
			String queryString = "from BusinessFormsFieldsInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public BusinessFormsFieldsInfo merge(
			BusinessFormsFieldsInfo detachedInstance) {
		LOGGER.debug("merging BusinessFormsFieldsInfo instance");
		try {
			BusinessFormsFieldsInfo result = (BusinessFormsFieldsInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BusinessFormsFieldsInfo instance) {
		LOGGER.debug("attaching dirty BusinessFormsFieldsInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BusinessFormsFieldsInfo instance) {
		LOGGER.debug("attaching clean BusinessFormsFieldsInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static BusinessFormsFieldsInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (BusinessFormsFieldsInfoDAOImpl) ctx
				.getBean("BusinessFormsFieldsInfoDAO");
	}
}