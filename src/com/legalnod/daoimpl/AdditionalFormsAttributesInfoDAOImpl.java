package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.AdditionalFormsAttributesInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdditionalFormsAttributesInfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.AdditionalFormsAttributesInfo
 * @author MyEclipse Persistence Tools
 */

public class AdditionalFormsAttributesInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdditionalFormsAttributesInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_CATEGORY = "attributeCategory";
	public static final String ATTRIBUTE_NAME = "attributeName";
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String REQUIRED_TYPE = "requiredType";
	public static final String RADIO_BUTTON_STATUS = "radioButtonStatus";
	public static final String RADIO_BUTTON_ID_STATUS = "radioButtonIdStatus";
	public static final String ADD_ANOTHER_RBSTATUS = "addAnotherRbstatus";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}
	
	
//	Dynamic Additional Service forms Data methods
	
	public List additionalServiceFormsIdValueFromDB(String stateName, String formName) {
		LOGGER.debug("finding Forms instance with State Name: "
				+ stateName + ", Form Name: " + formName);
		try {
			String queryString = "from Forms where state = '"+stateName+"' and formName = '"+formName+"'";			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List additionalServiceDynamicFormShowHideData(int formId) {
		LOGGER.debug("finding AdditionalFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "from AdditionalFormsAttributesInfo where forms = '"+formId+"' order by additionalFormsAttributesInfoId ";			
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List additionalServiceFormsDynamicFieldsAndValues(int formId) {
		LOGGER.debug("finding AdditionalFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {						

			String queryString = "select a.additionalFormsAttributesInfoId, a.attributeType, a.attributeName, b.attributeValue " +
					"from AdditionalFormsAttributesInfo a, AdditionalFormsFieldsInfo b " +
					"WHERE a.forms = \'" + formId + "\' and a.attributeType = b.attributeType " +
					"order by a.additionalFormsAttributesInfoId";
						
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List additionalServiceFormsDynamicFieldsAndValuesIDs(int formId) {
		LOGGER.debug("finding AdditionalFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select a.additionalFormsFieldsInfoId, b.additionalFormsAttributesInfoId, b.attributeName, b.attributeType  " +
			"from AdditionalFormsFieldsInfo a, AdditionalFormsAttributesInfo b  " +
			"WHERE b.forms = \'" + formId + "\' and a.attributeType = b.attributeType and b.requiredType is not null " +
			"and a.attributeValue is not null and a.attributeType != 'TFH' order by b.additionalFormsAttributesInfoId";	
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List addSerAttributeReqTypeIDsList(int formId) {
		LOGGER.debug("finding AdditionalFormsFieldsInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select a.additionalFormsFieldsInfoId " +
			"from AdditionalFormsFieldsInfo a, AdditionalFormsAttributesInfo b  " +
			"WHERE b.forms = \'" + formId + "\' and a.attributeType = b.attributeType and b.requiredType = 1 and b.requiredType is not null " +
			"and a.attributeValue is not null and a.attributeType != 'TFH' order by a.additionalFormsFieldsInfoId";	
						
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List additionalServiceRadioButtonStatus(int formId) {
		LOGGER.debug("finding AdditionalFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select distinct radioButtonStatus from AdditionalFormsAttributesInfo WHERE forms = \'" + formId + "\' and radioButtonStatus is not null";
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	

	public void save(AdditionalFormsAttributesInfo transientInstance) {
		LOGGER.debug("saving AdditionalFormsAttributesInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdditionalFormsAttributesInfo persistentInstance) {
		LOGGER.debug("deleting AdditionalFormsAttributesInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public AdditionalFormsAttributesInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting AdditionalFormsAttributesInfo instance with id: "
				+ id);
		try {
			AdditionalFormsAttributesInfo instance = (AdditionalFormsAttributesInfo) getHibernateTemplate()
					.get("com.legalnod.model.AdditionalFormsAttributesInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdditionalFormsAttributesInfo> findByExample(
			AdditionalFormsAttributesInfo instance) {
		LOGGER.debug("finding AdditionalFormsAttributesInfo instance by example");
		try {
			List<AdditionalFormsAttributesInfo> results = (List<AdditionalFormsAttributesInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding AdditionalFormsAttributesInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdditionalFormsAttributesInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AdditionalFormsAttributesInfo> findByAttributeCategory(
			Object attributeCategory) {
		return findByProperty(ATTRIBUTE_CATEGORY, attributeCategory);
	}

	public List<AdditionalFormsAttributesInfo> findByAttributeName(
			Object attributeName) {
		return findByProperty(ATTRIBUTE_NAME, attributeName);
	}

	public List<AdditionalFormsAttributesInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<AdditionalFormsAttributesInfo> findByRequiredType(
			Object requiredType) {
		return findByProperty(REQUIRED_TYPE, requiredType);
	}

	public List<AdditionalFormsAttributesInfo> findByRadioButtonStatus(
			Object radioButtonStatus) {
		return findByProperty(RADIO_BUTTON_STATUS, radioButtonStatus);
	}

	public List<AdditionalFormsAttributesInfo> findByRadioButtonIdStatus(
			Object radioButtonIdStatus) {
		return findByProperty(RADIO_BUTTON_ID_STATUS, radioButtonIdStatus);
	}

	public List<AdditionalFormsAttributesInfo> findByAddAnotherRbstatus(
			Object addAnotherRbstatus) {
		return findByProperty(ADD_ANOTHER_RBSTATUS, addAnotherRbstatus);
	}

	public List<AdditionalFormsAttributesInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<AdditionalFormsAttributesInfo> findByModifiedBy(
			Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all AdditionalFormsAttributesInfo instances");
		try {
			String queryString = "from AdditionalFormsAttributesInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdditionalFormsAttributesInfo merge(
			AdditionalFormsAttributesInfo detachedInstance) {
		LOGGER.debug("merging AdditionalFormsAttributesInfo instance");
		try {
			AdditionalFormsAttributesInfo result = (AdditionalFormsAttributesInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdditionalFormsAttributesInfo instance) {
		LOGGER.debug("attaching dirty AdditionalFormsAttributesInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdditionalFormsAttributesInfo instance) {
		LOGGER.debug("attaching clean AdditionalFormsAttributesInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdditionalFormsAttributesInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdditionalFormsAttributesInfoDAOImpl) ctx
				.getBean("AdditionalFormsAttributesInfoDAO");
	}
}