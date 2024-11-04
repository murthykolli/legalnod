package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.FivezerooneAppFormsAttributesInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * FivezerooneAppFormsAttributesInfo entities. Transaction control of the
 * save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.FivezerooneAppFormsAttributesInfo
 * @author MyEclipse Persistence Tools
 */

public class FivezerooneAppFormsAttributesInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FivezerooneAppFormsAttributesInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_NAME = "attributeName";
	public static final String ATTRIBUTE_SMALL_NAME = "attributeSmallName";
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String ATTRIBUTE_VALUE = "attributeValue";
	public static final String STATUS = "status";
	public static final String REQUIRED_ATTRIBUTE = "requiredAttribute";
	public static final String ATTRIBUTE_TYPE1 = "attributeType1";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}

	public void save(FivezerooneAppFormsAttributesInfo transientInstance) {
		LOGGER.debug("saving FivezerooneAppFormsAttributesInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
//	501 Application show hide DAO
	public List fiveZeroOneFormDynamicFormShowHideData() {
		LOGGER.debug("finding FivezerooneAppFormsAttributesInfo");
		try {
			String queryString = "from FivezerooneAppFormsAttributesInfo order by fivezerooneAppFormsAttributesInfoId ASC ";			
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	501 Application Status List DAO
	public List fiveZeroOneFormRadioButtonStatus() {
		LOGGER.debug("finding FivezerooneAppFormsAttributesInfo");
		try {
			String queryString = "select distinct status from FivezerooneAppFormsAttributesInfo WHERE status is not null";
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List attributeReqTypeIDsList() {
		LOGGER.debug("finding FivezerooneAppFormsAttributesInfo");
		try {
			String queryString = "select fivezerooneId from FivezerooneAppFormsAttributesInfo where requiredAttribute = 1 and requiredAttribute is not null order by fivezerooneAppFormsAttributesInfoId";				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

//	Checkout Finish Order Data Take from DB
	public List fiveZeroOneFormsDynamicFieldsAndValuesIDs() {
		LOGGER.debug("finding FivezerooneAppFormsAttributesInfo");
		try {
			String queryString = "select fivezerooneId, fivezerooneAppFormsAttributesInfoId, attributeSmallName, attributeType, attributeType1  " +
			"from FivezerooneAppFormsAttributesInfo WHERE requiredAttribute is not null and attributeValue is not null order by fivezerooneAppFormsAttributesInfoId";	
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(FivezerooneAppFormsAttributesInfo persistentInstance) {
		LOGGER.debug("deleting FivezerooneAppFormsAttributesInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public FivezerooneAppFormsAttributesInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting FivezerooneAppFormsAttributesInfo instance with id: "
				+ id);
		try {
			FivezerooneAppFormsAttributesInfo instance = (FivezerooneAppFormsAttributesInfo) getHibernateTemplate()
					.get("com.legalnod.model.FivezerooneAppFormsAttributesInfo",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FivezerooneAppFormsAttributesInfo> findByExample(
			FivezerooneAppFormsAttributesInfo instance) {
		LOGGER.debug("finding FivezerooneAppFormsAttributesInfo instance by example");
		try {
			List<FivezerooneAppFormsAttributesInfo> results = (List<FivezerooneAppFormsAttributesInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding FivezerooneAppFormsAttributesInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FivezerooneAppFormsAttributesInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FivezerooneAppFormsAttributesInfo> findByAttributeName(
			Object attributeName) {
		return findByProperty(ATTRIBUTE_NAME, attributeName);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByAttributeSmallName(
			Object attributeSmallName) {
		return findByProperty(ATTRIBUTE_SMALL_NAME, attributeSmallName);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByAttributeValue(
			Object attributeValue) {
		return findByProperty(ATTRIBUTE_VALUE, attributeValue);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByRequiredAttribute(
			Object requiredAttribute) {
		return findByProperty(REQUIRED_ATTRIBUTE, requiredAttribute);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByAttributeType1(
			Object attributeType1) {
		return findByProperty(ATTRIBUTE_TYPE1, attributeType1);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByLoadedBy(
			Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<FivezerooneAppFormsAttributesInfo> findByModifiedBy(
			Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all FivezerooneAppFormsAttributesInfo instances");
		try {
			String queryString = "from FivezerooneAppFormsAttributesInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FivezerooneAppFormsAttributesInfo merge(
			FivezerooneAppFormsAttributesInfo detachedInstance) {
		LOGGER.debug("merging FivezerooneAppFormsAttributesInfo instance");
		try {
			FivezerooneAppFormsAttributesInfo result = (FivezerooneAppFormsAttributesInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FivezerooneAppFormsAttributesInfo instance) {
		LOGGER.debug("attaching dirty FivezerooneAppFormsAttributesInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FivezerooneAppFormsAttributesInfo instance) {
		LOGGER.debug("attaching clean FivezerooneAppFormsAttributesInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FivezerooneAppFormsAttributesInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FivezerooneAppFormsAttributesInfoDAOImpl) ctx
				.getBean("FivezerooneAppFormsAttributesInfoDAO");
	}
}