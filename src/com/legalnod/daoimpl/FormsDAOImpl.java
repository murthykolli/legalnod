package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.Forms;

/**
 * A data access object (DAO) providing persistence and search support for Forms
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.legalnod.model.Forms
 * @author MyEclipse Persistence Tools
 */

public class FormsDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(FormsDAOImpl.class);
	// property constants
	public static final String FORM_NAME = "formName";
	public static final String STATE = "state";
	public static final String NO_OF_ATTRIBUTES = "noOfAttributes";
	public static final String REQUIRED_ATTRIBUTES = "requiredAttributes";
	public static final String STATUS = "status";
	public static final String DOC_CATEGORY = "docCategory";
	public static final String DOC_BUSINESS_CATEGORY = "docBusinessCategory";
	public static final String DOC_SUB_CATEGORY_FORM = "docSubCategoryForm";
	public static final String DOC_CATEGORY_BS = "docCategoryBs";
	public static final String DOC_ORDER_STATUS = "docOrderStatus";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String FEDERAL_STATUS = "federalStatus";
	public static final String TYPE_OF_DOCUMENT = "typeOfDocument";
	public static final String BUSINESS_SERVICES_BY_STATES = "businessServicesByStates";
	public static final String FOREIGN_QUALIFICATIONS_BY_STATES = "foreignQualificationsByStates";
	public static final String REQUIRED_ATTRIBUTES_OLD = "requiredAttributesOld";

	protected void initDao() {
		// do nothing
	}

	public void save(Forms transientInstance) {
		LOGGER.debug("saving Forms instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(Forms persistentInstance) {
		LOGGER.debug("deleting Forms instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public Forms findById(java.lang.Integer id) {
		LOGGER.debug("getting Forms instance with id: " + id);
		try {
			Forms instance = (Forms) getHibernateTemplate().get(
					"com.legalnod.model.Forms", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<Forms> findByExample(Forms instance) {
		LOGGER.debug("finding Forms instance by example");
		try {
			List<Forms> results = (List<Forms>) getHibernateTemplate()
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
		LOGGER.debug("finding Forms instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Forms as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Forms> findByFormName(Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<Forms> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Forms> findByNoOfAttributes(Object noOfAttributes) {
		return findByProperty(NO_OF_ATTRIBUTES, noOfAttributes);
	}

	public List<Forms> findByRequiredAttributes(Object requiredAttributes) {
		return findByProperty(REQUIRED_ATTRIBUTES, requiredAttributes);
	}

	public List<Forms> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<Forms> findByDocCategory(Object docCategory) {
		return findByProperty(DOC_CATEGORY, docCategory);
	}

	public List<Forms> findByDocBusinessCategory(Object docBusinessCategory) {
		return findByProperty(DOC_BUSINESS_CATEGORY, docBusinessCategory);
	}

	public List<Forms> findByDocSubCategoryForm(Object docSubCategoryForm) {
		return findByProperty(DOC_SUB_CATEGORY_FORM, docSubCategoryForm);
	}

	public List<Forms> findByDocCategoryBs(Object docCategoryBs) {
		return findByProperty(DOC_CATEGORY_BS, docCategoryBs);
	}

	public List<Forms> findByDocOrderStatus(Object docOrderStatus) {
		return findByProperty(DOC_ORDER_STATUS, docOrderStatus);
	}

	public List<Forms> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<Forms> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List<Forms> findByFederalStatus(Object federalStatus) {
		return findByProperty(FEDERAL_STATUS, federalStatus);
	}

	public List<Forms> findByTypeOfDocument(Object typeOfDocument) {
		return findByProperty(TYPE_OF_DOCUMENT, typeOfDocument);
	}

	public List<Forms> findByBusinessServicesByStates(
			Object businessServicesByStates) {
		return findByProperty(BUSINESS_SERVICES_BY_STATES,
				businessServicesByStates);
	}

	public List<Forms> findByForeignQualificationsByStates(
			Object foreignQualificationsByStates) {
		return findByProperty(FOREIGN_QUALIFICATIONS_BY_STATES,
				foreignQualificationsByStates);
	}

	public List<Forms> findByRequiredAttributesOld(Object requiredAttributesOld) {
		return findByProperty(REQUIRED_ATTRIBUTES_OLD, requiredAttributesOld);
	}

	public List findAll() {
		LOGGER.debug("finding all Forms instances");
		try {
			String queryString = "from Forms";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public Forms merge(Forms detachedInstance) {
		LOGGER.debug("merging Forms instance");
		try {
			Forms result = (Forms) getHibernateTemplate().merge(
					detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Forms instance) {
		LOGGER.debug("attaching dirty Forms instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Forms instance) {
		LOGGER.debug("attaching clean Forms instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FormsDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (FormsDAOImpl) ctx.getBean("FormsDAO");
	}
}