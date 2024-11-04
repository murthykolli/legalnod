package com.legalnod.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.legalnod.dao.DropdownStateDAO;

/**
 * @author MurthyK
 *
 */

public class DropdownStateDAOImpl extends HibernateDaoSupport implements DropdownStateDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(DropdownStateDAOImpl.class);
	
		// property constants
		public static final String DOCUMENT_CATEGORY = "documentCategory";
		
		protected void initDao() {
		// do nothing
		}
		
		public List findAll() {
			LOGGER.debug("finding all DropdownStateModel instances");
			try {
				String queryString = "from DropdownStateModel";
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				LOGGER.error("find all failed", re);
				throw re;
			}
		}
		
		public List findByStateListProperty(String propertyName, Object value) {
			LOGGER.debug("finding DropdownStateModel instance with property: "
					+ propertyName + ", value: " + value);
			try {
				String queryString = "from DropdownStateModel as model where model."
						+ propertyName + "= ?";
				return getHibernateTemplate().find(queryString, value);
			} catch (RuntimeException re) {
				LOGGER.error("find by DropdownStateModel name failed", re);
				throw re;
			}
		}
		
		public List findByCategory(Object documentCategory) {
			return findByStateListProperty(DOCUMENT_CATEGORY, documentCategory);
		}
		
//		Name Availability check type of company
		
		public List findByNameCheckListProperty() {
			LOGGER.debug("finding NameAvailabilityCheckSaving instance with property: ");
			try {
				String queryString = "from NACDropdownCompanyFormingModel order by documentID ASC";		
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				LOGGER.error("find by NameAvailabilityCheckSaving name failed", re);
				throw re;
			}
		}
		
		/*Forms selection with State Name*/
		
		public List findByAllFormsListProperty(String documentCategory, Object stateName) {
			try {
				String queryString = "from Forms where businessServicesByStates = '"+documentCategory+"' and state = '"+stateName+"' order by formName ASC";				
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				logger.error("find by Forms name failed", re);
				throw re;
			}
		}
		
		public List findByFQFormsListProperty(String documentCategory, Object stateName) {
			try {
				String queryString = "from Forms where foreignQualificationsByStates = '"+documentCategory+"' and state = '"+stateName+"' order by formName ASC";				
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				logger.error("find by Forms name failed", re);
				throw re;
			}
		}
		
		public List findByCategoriesListProperty(String documentCategory, Object stateName) {
			try {
				String queryString = "from Forms where businessServicesByStates = '"+documentCategory+"' and state = '"+stateName+"' order by docBusinessCategory ASC";				
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				logger.error("find by Forms name failed", re);
				throw re;
			}
		}
		
		public List findByFormsListWithCatAndStatesProperty(String documentCategory, Object stateName) {
			try {
				String queryString = "from Forms where docBusinessCategory = '"+documentCategory+"' and state = '"+stateName+"' order by formName ASC";				
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				logger.error("find by Forms name failed", re);
				throw re;
			}
		}		
		
		public List findServiceByStateCatategoryProperty(Object stateName) {
			try {
				String queryString = "from Forms where state = '"+stateName+"' order by docOrderStatus ASC";
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				logger.error("find by Forms name failed", re);
				throw re;
			}
		}
		
		public List findServiceByStateFormProperty(String documentCategory, Object stateName) {
			try {
				String queryString = "from Forms where docCategory = '"+documentCategory+"' and state = '"+stateName+"' order by formName ASC ";			
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				logger.error("find by Forms name failed", re);
				throw re;
			}
		}

		
}
