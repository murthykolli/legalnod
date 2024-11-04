package com.legalnod.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.dao.UsersInformationDAO;
import com.legalnod.model.UsersInformation;

/**
 * A data access object (DAO) providing persistence and search support for
 * UsersInformation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.legalnod.model.UsersInformation
 * @author MyEclipse Persistence Tools
 */

public class UsersInformationDAOImpl extends HibernateDaoSupport implements UsersInformationDAO{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UsersInformationDAOImpl.class);
	
	// property constants
	public static final String USER_NAME = "userName";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PASSWORD = "password";	
	public static final String PASSWORD_SALT = "passwordSalt";
	public static final String TYPE_OF_USER = "typeOfUser";
	public static final String SECURITY_PIN = "securityPin";
	public static final String ADMIN_TYPE = "adminType";
	public static final String CREATED_DATE = "createdDate";
	public static final String LAST_PASSWORD_CHANGED_DATE = "lastPasswordChangedDate";	
	public static final String EMAIL_SENT_DATE = "emailSentDate";
	
	protected void initDao() {
		// do nothing
	}

	public void save(UsersInformation transientInstance) {
		LOGGER.debug("saving UsersInformation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public List findByUserInfoProperty(String userName, Object passwordSalt) {
		LOGGER.debug("finding UsersInformation instance with property: "
				+ userName + ", value: " + passwordSalt);
		try {
			String queryString = "from UsersInformation where userName = '"+userName+"' and passwordSalt = '"+passwordSalt+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by UsersInformation name failed", re);
			throw re;
		}
	}
	
	public UsersInformation findByUserInfoFromDB(String userName) {
		LOGGER.debug("finding UsersInformation instance with property: "
				+ userName);
		try {
			String queryString = "from UsersInformation WHERE userName = '"+userName+"'";
			return (UsersInformation) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(UsersInformation persistentInstance) {
		LOGGER.debug("deleting UsersInformation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public UsersInformation findById(java.lang.Integer id) {
		LOGGER.debug("getting UsersInformation instance with id: " + id);
		try {
			UsersInformation instance = (UsersInformation) getHibernateTemplate()
					.get("com.legalnod.model.UsersInformation", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<UsersInformation> findByExample(UsersInformation instance) {
		LOGGER.debug("finding UsersInformation instance by example");
		try {
			List<UsersInformation> results = (List<UsersInformation>) getHibernateTemplate()
					.findByExample(instance);
			LOGGER.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByEmailChangeProperty(String userName) {
		LOGGER.debug("finding UsersInformation instance with property: "
				+ userName );
		try {
			String queryString = "from UsersInformation where  userName = '"+userName+"'";			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		LOGGER.debug("finding UsersInformation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UsersInformation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List<UsersInformation> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<UsersInformation> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<UsersInformation> findByTypeOfUser(Object typeOfUser) {
		return findByProperty(TYPE_OF_USER, typeOfUser);
	}

	public List<UsersInformation> findBySecurityPin(Object securityPin) {
		return findByProperty(SECURITY_PIN, securityPin);
	}

	public List<UsersInformation> findByAdminType(Object adminType) {
		return findByProperty(ADMIN_TYPE, adminType);
	}
	
	public List<UsersInformation> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}
	
	public List<UsersInformation> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}	
	
	public List findAll() {
		LOGGER.debug("finding all UsersInformation instances");
		try {
			String queryString = "from UsersInformation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public UsersInformation merge(UsersInformation detachedInstance) {
		LOGGER.debug("merging UsersInformation instance");
		try {
			UsersInformation result = (UsersInformation) getHibernateTemplate()
					.merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UsersInformation instance) {
		LOGGER.debug("attaching dirty UsersInformation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UsersInformation instance) {
		LOGGER.debug("attaching clean UsersInformation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			LOGGER.debug("attach successful");
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static UsersInformationDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsersInformationDAOImpl) ctx.getBean("UsersInformationDAO");
	}
}