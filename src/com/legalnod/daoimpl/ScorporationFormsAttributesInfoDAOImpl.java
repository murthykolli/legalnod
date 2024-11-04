package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.ScorporationFormsAttributesInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * ScorporationFormsAttributesInfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.ScorporationFormsAttributesInfo
 * @author MyEclipse Persistence Tools
 */

public class ScorporationFormsAttributesInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ScorporationFormsAttributesInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_NAME = "attributeName";
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String ATTRIBUTE_FIELD_NAME = "attributeFieldName";
	public static final String ATTRIBUTE_VALUE = "attributeValue";
	public static final String STATUS = "status";
	public static final String REQUIRED_TYPE = "requiredType";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}
		
//	S Corporation show hide DAO
	public List sCorporationFormDynamicFormShowHideData() {
		LOGGER.debug("finding ScorporationFormsAttributesInfo");
		try {
			String queryString = "from ScorporationFormsAttributesInfo where attributeFieldName is not null order by scorporationFormsAttributesInfoId ASC ";			
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	S Corporation Status List DAO
	public List sCorporationFormRadioButtonStatus() {
		LOGGER.debug("finding ScorporationFormsAttributesInfo");
		try {
			String queryString = "select distinct status from ScorporationFormsAttributesInfo WHERE status is not null";
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List attributeReqTypeIDsList() {
		LOGGER.debug("finding ScorporationFormsAttributesInfo");
		try {
			String queryString = "select scorporationId from ScorporationFormsAttributesInfo where requiredType = 1 and requiredType is not null order by scorporationFormsAttributesInfoId";				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Checkout Finish Order Data Take from DB
	public List sCorpFormsDynamicFieldsAndValuesIDs() {
		LOGGER.debug("finding ScorporationFormsAttributesInfo");
		try {
			String queryString = "select scorporationId, scorporationFormsAttributesInfoId, attributeName, attributeType  " +
			"from ScorporationFormsAttributesInfo WHERE requiredType is not null order by scorporationFormsAttributesInfoId";	
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void save(ScorporationFormsAttributesInfo transientInstance) {
		LOGGER.debug("saving ScorporationFormsAttributesInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(ScorporationFormsAttributesInfo persistentInstance) {
		LOGGER.debug("deleting ScorporationFormsAttributesInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public ScorporationFormsAttributesInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting ScorporationFormsAttributesInfo instance with id: "
				+ id);
		try {
			ScorporationFormsAttributesInfo instance = (ScorporationFormsAttributesInfo) getHibernateTemplate()
					.get("com.legalnod.model.ScorporationFormsAttributesInfo",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ScorporationFormsAttributesInfo> findByExample(
			ScorporationFormsAttributesInfo instance) {
		LOGGER.debug("finding ScorporationFormsAttributesInfo instance by example");
		try {
			List<ScorporationFormsAttributesInfo> results = (List<ScorporationFormsAttributesInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding ScorporationFormsAttributesInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ScorporationFormsAttributesInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ScorporationFormsAttributesInfo> findByAttributeName(
			Object attributeName) {
		return findByProperty(ATTRIBUTE_NAME, attributeName);
	}

	public List<ScorporationFormsAttributesInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<ScorporationFormsAttributesInfo> findByAttributeFieldName(
			Object attributeFieldName) {
		return findByProperty(ATTRIBUTE_FIELD_NAME, attributeFieldName);
	}

	public List<ScorporationFormsAttributesInfo> findByAttributeValue(
			Object attributeValue) {
		return findByProperty(ATTRIBUTE_VALUE, attributeValue);
	}

	public List<ScorporationFormsAttributesInfo> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<ScorporationFormsAttributesInfo> findByRequiredType(
			Object requiredType) {
		return findByProperty(REQUIRED_TYPE, requiredType);
	}

	public List<ScorporationFormsAttributesInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<ScorporationFormsAttributesInfo> findByModifiedBy(
			Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all ScorporationFormsAttributesInfo instances");
		try {
			String queryString = "from ScorporationFormsAttributesInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ScorporationFormsAttributesInfo merge(
			ScorporationFormsAttributesInfo detachedInstance) {
		LOGGER.debug("merging ScorporationFormsAttributesInfo instance");
		try {
			ScorporationFormsAttributesInfo result = (ScorporationFormsAttributesInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ScorporationFormsAttributesInfo instance) {
		LOGGER.debug("attaching dirty ScorporationFormsAttributesInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ScorporationFormsAttributesInfo instance) {
		LOGGER.debug("attaching clean ScorporationFormsAttributesInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ScorporationFormsAttributesInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ScorporationFormsAttributesInfoDAOImpl) ctx
				.getBean("ScorporationFormsAttributesInfoDAO");
	}
}