package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.BusinessFormsAttributesInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * BusinessFormsAttributesInfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.legalnod.model.BusinessFormsAttributesInfo
 * @author MyEclipse Persistence Tools
 */

public class BusinessFormsAttributesInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BusinessFormsAttributesInfoDAOImpl.class);
	// property constants
	public static final String ATTRIBUTE_CATEGORY = "attributeCategory";
	public static final String ATTRIBUTE_NAME = "attributeName";
	public static final String ATTRIBUTE_TYPE = "attributeType";
	public static final String REQUIRED_TYPE = "requiredType";
	public static final String RADIO_BUTTON_STATUS = "radioButtonStatus";
	public static final String ABBREVATION_STATUS = "abbrevationStatus";
	public static final String RADIO_BUTTON_ID_STATUS = "radioButtonIdStatus";
	public static final String ADD_ANOTHER_RBSTATUS = "addAnotherRbstatus";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}

//	Dynamic State forms Data methods
	
	public List stateFormsIdValueFromDB(String stateName, String formName) {
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
	
	public List abbreviationStatusTakeFromDB(int id) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with ID: "
				+ id );
		try {
			String queryString = "from BusinessFormsAttributesInfo where forms = '"+id+"' and attributeType = 'TF1'";			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List abbreviationStatusForAllTakeFromDB(int id, String type) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with ID: "
				+ id );
		try {
			String queryString = "from BusinessFormsAttributesInfo where forms = '"+id+"' and attributeType = '"+type+"'";			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List stateFormDynamicFormShowHideData(int formId) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "from BusinessFormsAttributesInfo where forms = '"+formId+"' order by businessFormsAttributesInfoId ";			
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List busStateFormsDynamicFieldsAndValues(int formId) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select a.businessFormsAttributesInfoId, a.attributeType, a.attributeName, b.attributeValue " +
					"from BusinessFormsAttributesInfo a, BusinessFormsFieldsInfo b " +
					"WHERE a.forms = \'" + formId + "\' and a.attributeType = b.attributeType " +
					"order by a.businessFormsAttributesInfoId";
						
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List attributeReqTypeIDsList(int formId) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select a.businessFormsFieldsInfoId " +
			"from BusinessFormsFieldsInfo a, BusinessFormsAttributesInfo b  " +
			"WHERE b.forms = \'" + formId + "\' and a.attributeType = b.attributeType and b.requiredType = 1 and b.requiredType is not null " +
			"and a.attributeValue is not null and a.attributeType != 'TFH' order by a.businessFormsFieldsInfoId";	
						
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List busStateFormsDynamicFieldsAndValuesIDs(int formId) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select a.businessFormsFieldsInfoId, b.businessFormsAttributesInfoId, b.attributeName, b.attributeType  " +
			"from BusinessFormsFieldsInfo a, BusinessFormsAttributesInfo b  " +
			"WHERE b.forms = \'" + formId + "\' and a.attributeType = b.attributeType and b.requiredType is not null " +
			"and a.attributeValue is not null and a.attributeType != 'TFH' order by b.businessFormsAttributesInfoId";	
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List stateFormRadioButtonStatus(int formId) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with Form Id: "
				+ formId );
		try {
			String queryString = "select distinct radioButtonStatus from BusinessFormsAttributesInfo WHERE forms = \'" + formId + "\' and radioButtonStatus is not null";
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void save(BusinessFormsAttributesInfo transientInstance) {
		LOGGER.debug("saving BusinessFormsAttributesInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(BusinessFormsAttributesInfo persistentInstance) {
		LOGGER.debug("deleting BusinessFormsAttributesInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public BusinessFormsAttributesInfo findById(java.lang.Integer id) {
		LOGGER.debug("getting BusinessFormsAttributesInfo instance with id: " + id);
		try {
			BusinessFormsAttributesInfo instance = (BusinessFormsAttributesInfo) getHibernateTemplate()
					.get("com.legalnod.model.BusinessFormsAttributesInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<BusinessFormsAttributesInfo> findByExample(
			BusinessFormsAttributesInfo instance) {
		LOGGER.debug("finding BusinessFormsAttributesInfo instance by example");
		try {
			List<BusinessFormsAttributesInfo> results = (List<BusinessFormsAttributesInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding BusinessFormsAttributesInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BusinessFormsAttributesInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BusinessFormsAttributesInfo> findByAttributeCategory(
			Object attributeCategory) {
		return findByProperty(ATTRIBUTE_CATEGORY, attributeCategory);
	}

	public List<BusinessFormsAttributesInfo> findByAttributeName(
			Object attributeName) {
		return findByProperty(ATTRIBUTE_NAME, attributeName);
	}

	public List<BusinessFormsAttributesInfo> findByAttributeType(
			Object attributeType) {
		return findByProperty(ATTRIBUTE_TYPE, attributeType);
	}

	public List<BusinessFormsAttributesInfo> findByRequiredType(
			Object requiredType) {
		return findByProperty(REQUIRED_TYPE, requiredType);
	}

	public List<BusinessFormsAttributesInfo> findByRadioButtonStatus(
			Object radioButtonStatus) {
		return findByProperty(RADIO_BUTTON_STATUS, radioButtonStatus);
	}

	public List<BusinessFormsAttributesInfo> findByAbbrevationStatus(
			Object abbrevationStatus) {
		return findByProperty(ABBREVATION_STATUS, abbrevationStatus);
	}

	public List<BusinessFormsAttributesInfo> findByRadioButtonIdStatus(
			Object radioButtonIdStatus) {
		return findByProperty(RADIO_BUTTON_ID_STATUS, radioButtonIdStatus);
	}

	public List<BusinessFormsAttributesInfo> findByAddAnotherRbstatus(
			Object addAnotherRbstatus) {
		return findByProperty(ADD_ANOTHER_RBSTATUS, addAnotherRbstatus);
	}

	public List<BusinessFormsAttributesInfo> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<BusinessFormsAttributesInfo> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all BusinessFormsAttributesInfo instances");
		try {
			String queryString = "from BusinessFormsAttributesInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public BusinessFormsAttributesInfo merge(
			BusinessFormsAttributesInfo detachedInstance) {
		LOGGER.debug("merging BusinessFormsAttributesInfo instance");
		try {
			BusinessFormsAttributesInfo result = (BusinessFormsAttributesInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BusinessFormsAttributesInfo instance) {
		LOGGER.debug("attaching dirty BusinessFormsAttributesInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BusinessFormsAttributesInfo instance) {
		LOGGER.debug("attaching clean BusinessFormsAttributesInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static BusinessFormsAttributesInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (BusinessFormsAttributesInfoDAOImpl) ctx
				.getBean("BusinessFormsAttributesInfoDAO");
	}
}