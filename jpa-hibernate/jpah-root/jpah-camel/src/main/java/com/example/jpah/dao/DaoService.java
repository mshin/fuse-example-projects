package com.example.jpah.dao;

//import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Inject this class into Classes that need access to a Dao.
 * 
 * Put Dao classes in here for access from Spring.
 * 
 * Uses reflection to get values, automatically mapping Dao classes to entities
 * under the assumption the Dao class is ${Entity}Dao.
 * 
 * Lazy Initializes Dao classes; Should only ever be 1 of each Dao.
 * 
 * @author mshin
 *
 */
public class DaoService {

	/*
	 * This naming convention must be followed.
	 * 
	 * Add all future Dao classes here so they can be accessed from Spring.
	 */
	private UserDao userDao;
	
	private static final String CLASS_NAME = DaoService.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	/**
	 * Use reflection to map entities to DAOs.
	 * @param entity
	 * @return
	 */
	public <T> BaseDao<T, Integer> getDao(T entity) {
		
		String firstLowerDaoName = entity.getClass().getSimpleName() + "Dao";
		firstLowerDaoName = firstLowerDaoName.substring(0, 1).toLowerCase() + firstLowerDaoName.substring(1);
		
		Object dao = null;
		Field field = null;
		try {
			field = this.getClass().getDeclaredField(firstLowerDaoName);
			dao = field.get(this);
		} 
		catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		
		if (null != dao) {

			return (BaseDao<T, Integer>) dao;
		}
		else {
			LOGGER.error("dao was null! for entity Class " + entity.getClass().getSimpleName());
			return null;
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
