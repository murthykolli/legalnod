package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.StateTaxFormsAttributesInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * StateTaxFormsAttributesInfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.StateTaxFormsAttributesInfo
 * @author MyEclipse Persistence Tools
 */

public class StateTaxFormsAttributesInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StateTaxFormsAttributesInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_CATEGORY = "attributeCategory";
	public static final String ATTRIBUTE_NAME = "attributeName";
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String REQUIRED_TYPE = "requiredType";
	public static final String RADI0_BUTTON_STATUS = "radi0ButtonStatus";
	public static final String RADIO_BUTTON_ID_STATUS = "radioButtonIdStatus";
	public static final String ADD_ANOTHER_RBSTATUS = "addAnotherRbstatus";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}
	
//	Dynamic State Tax Id forms Data methods
	
	public List stateTaxIdFormsIdValueFromDB(String stateName, String formName) {
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
	
	public List stateTaxIdDynamicFormShowHideData(int formId) {
		LOGGER.debug("finding StateTaxFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "from StateTaxFormsAttributesInfo where forms = '"+formId+"' order by stateTaxFormsAttributesInfoId ";			
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List stateTaxIdFormsDynamicFieldsAndValues(int formId) {
		LOGGER.debug("finding StateTaxFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {						

			String queryString = "select a.stateTaxFormsAttributesInfoId, a.attributeType, a.attributeName, b.attributeValue " +
					"from StateTaxFormsAttributesInfo a, StateTaxFormsFieldsInfo b " +
					"WHERE a.forms = \'" + formId + "\' and a.attributeType = b.attributeType " +
					"order by a.stateTaxFormsAttributesInfoId";
						
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List stateTaxIdAttributeReqTypeIDsList(int formId) {
		LOGGER.debug("finding StateTaxFormsFieldsInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select a.stateTaxFormsFieldsInfoId " +
			"from StateTaxFormsFieldsInfo a, StateTaxFormsAttributesInfo b  " +
			"WHERE b.forms = \'" + formId + "\' and a.attributeType = b.attributeType and b.requiredType = 1 and b.requiredType is not null " +
			"and a.attributeValue is not null and a.attributeType != 'TFH' order by a.stateTaxFormsFieldsInfoId";	
						
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List stateTaxIdFormsDynamicFieldsAndValuesIDs(int formId) {
		LOGGER.debug("finding StateTaxFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select a.stateTaxFormsFieldsInfoId, b.stateTaxFormsAttributesInfoId, b.attributeName, b.attributeType  " +
			"from StateTaxFormsFieldsInfo a, StateTaxFormsAttributesInfo b  " +
			"WHERE b.forms = \'" + formId + "\' and a.attributeType = b.attributeType and b.requiredType is not null " +
			"and a.attributeValue is not null and a.attributeType != 'TFH' order by b.stateTaxFormsAttributesInfoId";	
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List stateTaxIdRadioButtonStatus(int formId) {
		LOGGER.debug("finding StateTaxFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select distinct radioButtonStatus from StateTaxFormsAttributesInfo WHERE forms = \'" + formId + "\' and radioButtonStatus is not null";
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	public void save(StateTaxFormsAttributesInfo transientInstance) {
		LOGGER.debug("saving StateTaxFormsAttributesInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(StateTaxFormsAttributesInfo persistentInstance) {
		LOGGER.debug("deleting StateTaxFormsAttributesInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public StateTaxFormsAttributesInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting StateTaxFormsAttributesInfo instance with id: " + id);
		try {
			StateTaxFormsAttributesInfo instance = (StateTaxFormsAttributesInfo) getHibernateTemplate()
					.get("com.legalnod.model.StateTaxFormsAttributesInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<StateTaxFormsAttributesInfo> findByExample(
			StateTaxFormsAttributesInfo instance) {
		LOGGER.debug("finding StateTaxFormsAttributesInfo instance by example");
		try {
			List<StateTaxFormsAttributesInfo> results = (List<StateTaxFormsAttributesInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding StateTaxFormsAttributesInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StateTaxFormsAttributesInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<StateTaxFormsAttributesInfo> findByAttributeCategory(
			Object attributeCategory) {
		return findByProperty(ATTRIBUTE_CATEGORY, attributeCategory);
	}

	public List<StateTaxFormsAttributesInfo> findByAttributeName(
			Object attributeName) {
		return findByProperty(ATTRIBUTE_NAME, attributeName);
	}

	public List<StateTaxFormsAttributesInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<StateTaxFormsAttributesInfo> findByRequiredType(
			Object requiredType) {
		return findByProperty(REQUIRED_TYPE, requiredType);
	}

	public List<StateTaxFormsAttributesInfo> findByRadi0ButtonStatus(
			Object radi0ButtonStatus) {
		return findByProperty(RADI0_BUTTON_STATUS, radi0ButtonStatus);
	}

	public List<StateTaxFormsAttributesInfo> findByRadioButtonIdStatus(
			Object radioButtonIdStatus) {
		return findByProperty(RADIO_BUTTON_ID_STATUS, radioButtonIdStatus);
	}

	public List<StateTaxFormsAttributesInfo> findByAddAnotherRbstatus(
			Object addAnotherRbstatus) {
		return findByProperty(ADD_ANOTHER_RBSTATUS, addAnotherRbstatus);
	}

	public List<StateTaxFormsAttributesInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<StateTaxFormsAttributesInfo> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all StateTaxFormsAttributesInfo instances");
		try {
			String queryString = "from StateTaxFormsAttributesInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public StateTaxFormsAttributesInfo merge(
			StateTaxFormsAttributesInfo detachedInstance) {
		LOGGER.debug("merging StateTaxFormsAttributesInfo instance");
		try {
			StateTaxFormsAttributesInfo result = (StateTaxFormsAttributesInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StateTaxFormsAttributesInfo instance) {
		LOGGER.debug("attaching dirty StateTaxFormsAttributesInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StateTaxFormsAttributesInfo instance) {
		LOGGER.debug("attaching clean StateTaxFormsAttributesInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static StateTaxFormsAttributesInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (StateTaxFormsAttributesInfoDAOImpl) ctx
				.getBean("StateTaxFormsAttributesInfoDAO");
	}
}