package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.Abbrevations;

/**
 * A data access object (DAO) providing persistence and search support for
 * Abbrevations entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.Abbrevations
 * @author MyEclipse Persistence Tools
 */

public class AbbrevationsDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbbrevationsDAOImpl.class);
	// property constants
	public static final String FORM_NAME = "formName";
	public static final String STATE = "state";
	public static final String ABBREVATION = "abbrevation";
	public static final String REPLACEMENT_ABBREVATION = "replacementAbbrevation";
	public static final String COMMENTS = "comments";
	public static final String LOADED_BY = "loadedBy";
	public static final String MODIFIED_BY = "modifiedBy";

	protected void initDao() {
		// do nothing
	}
	
//	Replacement abbreviation take from DB
	
	public List replacementAbbreviationTakeFromDB(int id) {
		LOGGER.debug("finding Abbrevations instance with ID: "
				+ id );
		try {
			String queryString = "from Abbrevations where forms = '"+id+"' ";			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Abbreviation Names List take from DB
	
	public List abbreviationNamesListtakefromDB(int formId) {
		LOGGER.debug("finding Abbrevations instance with Form Id: "
				+ formId );
		try {
			String queryString = "select abbrevation from Abbrevations WHERE forms = \'" + formId + "\' order by abbrevationId ASC";
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void save(Abbrevations transientInstance) {
		LOGGER.debug("saving Abbrevations instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(Abbrevations persistentInstance) {
		LOGGER.debug("deleting Abbrevations instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public Abbrevations findById(java.lang.Integer id) {
		LOGGER.debug("getting Abbrevations instance with id: " + id);
		try {
			Abbrevations instance = (Abbrevations) getHibernateTemplate().get(
					"com.legalnod.model.Abbrevations", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<Abbrevations> findByExample(Abbrevations instance) {
		LOGGER.debug("finding Abbrevations instance by example");
		try {
			List<Abbrevations> results = (List<Abbrevations>) getHibernateTemplate()
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
		LOGGER.debug("finding Abbrevations instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Abbrevations as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Abbrevations> findByFormName(Object formName) {
		return findByProperty(FORM_NAME, formName);
	}

	public List<Abbrevations> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Abbrevations> findByAbbrevation(Object abbrevation) {
		return findByProperty(ABBREVATION, abbrevation);
	}

	public List<Abbrevations> findByReplacementAbbrevation(
			Object replacementAbbrevation) {
		return findByProperty(REPLACEMENT_ABBREVATION, replacementAbbrevation);
	}

	public List<Abbrevations> findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List<Abbrevations> findByLoadedBy(Object loadedBy) {
		return findByProperty(LOADED_BY, loadedBy);
	}

	public List<Abbrevations> findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
	}

	public List findAll() {
		LOGGER.debug("finding all Abbrevations instances");
		try {
			String queryString = "from Abbrevations";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public Abbrevations merge(Abbrevations detachedInstance) {
		LOGGER.debug("merging Abbrevations instance");
		try {
			Abbrevations result = (Abbrevations) getHibernateTemplate().merge(
					detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Abbrevations instance) {
		LOGGER.debug("attaching dirty Abbrevations instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Abbrevations instance) {
		LOGGER.debug("attaching clean Abbrevations instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AbbrevationsDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AbbrevationsDAOImpl) ctx.getBean("AbbrevationsDAO");
	}
}