package com.legalnod.dao;

import java.util.List;

/**
 * @author MurthyK
 *
 */

public interface DropdownStateDAO {
	
	public List findAll();
	
	public List findByCategory(Object documentCategory);
	
	public List findByStateListProperty(String propertyName, Object value);

}
