package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.FederalTaxIdFormsAttributesInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * FederalTaxIdFormsAttributesInfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.FederalTaxIdFormsAttributesInfo
 * @author MyEclipse Persistence Tools
 */

public class FederalTaxIdFormsAttributesInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FederalTaxIdFormsAttributesInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_NAME = "attributeName";
	public static final String ATTRIBUTE_FIELD_NAME = "attributeFieldName";
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String ATTRIBUTE_VALUE = "attributeValue";
	public static final String STATUS = "status";
	public static final String REQUIRED_TYPE = "requiredType";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}
	
//	Federal tax id show hide DAO
	public List federalFormDynamicFormShowHideData() {
		LOGGER.debug("finding FederalTaxIdFormsAttributesInfo");
		try {
			String queryString = "from FederalTaxIdFormsAttributesInfo order by federalTaxIdFormsAttributesInfoId ASC ";			
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Federal tax Status List DAO
	public List federalFormRadioButtonStatus() {
		LOGGER.debug("finding FederalTaxIdFormsAttributesInfo");
		try {
			String queryString = "select distinct status from FederalTaxIdFormsAttributesInfo WHERE status is not null";
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List attributeReqTypeIDsList() {
		LOGGER.debug("finding FederalTaxIdFormsAttributesInfo");
		try {
			String queryString = "select federaltaxId from FederalTaxIdFormsAttributesInfo where requiredType = 1 and requiredType is not null order by federalTaxIdFormsAttributesInfoId";				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Checkout Finish Order Data Take from DB
	public List federalTaxFormsDynamicFieldsAndValuesIDs() {
		LOGGER.debug("finding FederalTaxIdFormsAttributesInfo");
		try {
			String queryString = "select federaltaxId, federalTaxIdFormsAttributesInfoId, attributeName, attributeType  " +
			"from FederalTaxIdFormsAttributesInfo WHERE requiredType is not null and attributeValue is not null order by federalTaxIdFormsAttributesInfoId";	
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void save(FederalTaxIdFormsAttributesInfo transientInstance) {
		LOGGER.debug("saving FederalTaxIdFormsAttributesInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(FederalTaxIdFormsAttributesInfo persistentInstance) {
		LOGGER.debug("deleting FederalTaxIdFormsAttributesInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public FederalTaxIdFormsAttributesInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting FederalTaxIdFormsAttributesInfo instance with id: "
				+ id);
		try {
			FederalTaxIdFormsAttributesInfo instance = (FederalTaxIdFormsAttributesInfo) getHibernateTemplate()
					.get("com.legalnod.model.FederalTaxIdFormsAttributesInfo",
							id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FederalTaxIdFormsAttributesInfo> findByExample(
			FederalTaxIdFormsAttributesInfo instance) {
		LOGGER.debug("finding FederalTaxIdFormsAttributesInfo instance by example");
		try {
			List<FederalTaxIdFormsAttributesInfo> results = (List<FederalTaxIdFormsAttributesInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding FederalTaxIdFormsAttributesInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FederalTaxIdFormsAttributesInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FederalTaxIdFormsAttributesInfo> findByAttributeName(
			Object attributeName) {
		return findByProperty(ATTRIBUTE_NAME, attributeName);
	}

	public List<FederalTaxIdFormsAttributesInfo> findByAttributeFieldName(
			Object attributeFieldName) {
		return findByProperty(ATTRIBUTE_FIELD_NAME, attributeFieldName);
	}

	public List<FederalTaxIdFormsAttributesInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<FederalTaxIdFormsAttributesInfo> findByAttributeValue(
			Object attributeValue) {
		return findByProperty(ATTRIBUTE_VALUE, attributeValue);
	}

	public List<FederalTaxIdFormsAttributesInfo> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<FederalTaxIdFormsAttributesInfo> findByRequiredType(
			Object requiredType) {
		return findByProperty(REQUIRED_TYPE, requiredType);
	}

	public List<FederalTaxIdFormsAttributesInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<FederalTaxIdFormsAttributesInfo> findByModifiedBy(
			Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all FederalTaxIdFormsAttributesInfo instances");
		try {
			String queryString = "from FederalTaxIdFormsAttributesInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FederalTaxIdFormsAttributesInfo merge(
			FederalTaxIdFormsAttributesInfo detachedInstance) {
		LOGGER.debug("merging FederalTaxIdFormsAttributesInfo instance");
		try {
			FederalTaxIdFormsAttributesInfo result = (FederalTaxIdFormsAttributesInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FederalTaxIdFormsAttributesInfo instance) {
		LOGGER.debug("attaching dirty FederalTaxIdFormsAttributesInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FederalTaxIdFormsAttributesInfo instance) {
		LOGGER.debug("attaching clean FederalTaxIdFormsAttributesInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FederalTaxIdFormsAttributesInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FederalTaxIdFormsAttributesInfoDAOImpl) ctx
				.getBean("FederalTaxIdFormsAttributesInfoDAO");
	}
}