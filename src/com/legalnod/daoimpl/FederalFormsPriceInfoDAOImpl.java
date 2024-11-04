package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.model.FederalFormsPriceInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * FederalFormsPriceInfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.FederalFormsPriceInfo
 * @author MyEclipse Persistence Tools
 */

public class FederalFormsPriceInfoDAOImpl extends HibernateDaoSupport {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FederalFormsPriceInfoDAOImpl.class);

	// property constants

	protected void initDao() {
		// do nothing
	}
	
//	FormFederal Price take From DB
	
	public List federalFormPriceProperty(String typeOfDoc) {
		LOGGER.debug("finding FederalFormsPriceInfo instance with property: value: " + typeOfDoc);
		try {
			String queryString = "select price from FederalFormsPriceInfo where typeOfFees = 'Processing Fee' and formName = '"+typeOfDoc+"'";			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by FederalFormsPriceInfo name failed", re);
			throw re;
		}
	}
	
//	All Federal forms price List take from DB
	
	public List allFederalFormsPriceListTakeFromDB(String docName) {
		LOGGER.debug("finding FederalFormsPriceInfo instance with Form Name: "+ docName );
		try {
			String queryString = "from FederalFormsPriceInfo WHERE formName = \'" + docName + "\' order by federalFormsPriceInfoId ASC";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void save(FederalFormsPriceInfo transientInstance) {
		LOGGER.debug("saving FederalFormsPriceInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(FederalFormsPriceInfo persistentInstance) {
		LOGGER.debug("deleting FederalFormsPriceInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public List<FederalFormsPriceInfo> findByExample(
			FederalFormsPriceInfo instance) {
		LOGGER.debug("finding FederalFormsPriceInfo instance by example");
		try {
			List<FederalFormsPriceInfo> results = (List<FederalFormsPriceInfo>) getHibernateTemplate()
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
		LOGGER.debug("finding FederalFormsPriceInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FederalFormsPriceInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		LOGGER.debug("finding all FederalFormsPriceInfo instances");
		try {
			String queryString = "from FederalFormsPriceInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FederalFormsPriceInfo merge(FederalFormsPriceInfo detachedInstance) {
		LOGGER.debug("merging FederalFormsPriceInfo instance");
		try {
			FederalFormsPriceInfo result = (FederalFormsPriceInfo) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FederalFormsPriceInfo instance) {
		LOGGER.debug("attaching dirty FederalFormsPriceInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FederalFormsPriceInfo instance) {
		LOGGER.debug("attaching clean FederalFormsPriceInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FederalFormsPriceInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FederalFormsPriceInfoDAOImpl) ctx
				.getBean("FederalFormsPriceInfoDAO");
	}
}