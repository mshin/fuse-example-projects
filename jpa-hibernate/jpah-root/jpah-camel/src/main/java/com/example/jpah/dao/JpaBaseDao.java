package com.example.jpah.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/*
 * @Transactional allows methods that must happen in a transaction to work, such as create, update, delete
 */
@Transactional
public abstract class JpaBaseDao<T, Id> implements BaseDao<T, Integer> {
	
	protected Class<T> entityClass;
	
	private static final String CLASS_NAME = JpaBaseDao.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	/*
	 * unitName is the name of the persistence-unit in META-INF/persistence.xml
	 */
	@PersistenceContext(unitName="hibernate_with_postgres")
	protected EntityManager entityManager;	
 
	
	@SuppressWarnings("unchecked")
	public JpaBaseDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

    @Override
    public <U extends T> void persist(U entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    @Override
    public <U extends T> List<U> update(Iterable<U> entities) {
    	List<U> list = new ArrayList<U>();
    	for (U u : entities) {
    		list.add(entityManager.merge(u));
    	}
    	//TODO should this go inside or outside loop?
    	entityManager.flush();
    	return list;
    }
    
    @Override
    public <U extends T> U update(U entity) {
        U updated = entityManager.merge(entity);
        entityManager.flush();
        return updated;
    }
 
    @Override
    public boolean exists(Integer id) {
    	return findById(id) == null ? false : true;
    }
    
    @Override
    public T findById(Integer id) {
        return entityManager.find(this.entityClass, id);
    }
 
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
         Query query = entityManager.createQuery("from " + this.entityClass.getName());
         LOGGER.debug("findAll query: " + query.toString());
         return (List<T>) query.getResultList();
    }
    
    @Override
    public List<T> findAll(Iterable<Integer> ids) {
    	List<T> list = new ArrayList<T>();
		for (Integer id : ids) {
			if(id != null) list.add(findById(id));
		}
		return list;
    }

    @Override
    public int count() {
    	Query query = entityManager.createQuery("select count(*) from " + this.entityClass.getName());
    	LOGGER.debug("count query: " + query.toString());
    	return query.executeUpdate();
    }

    @Override
    public void delete(Integer id) {
    	T found = findById(id);
    	if (null != found) delete(found);
    	else LOGGER.warn("Did not delete entity " + this.entityClass.getSimpleName() + 
    			" with id " + id + " because no entity with that id was found in the DB.");
    }
    
    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }
    
    @Override
    public void delete(Iterable<? extends T> entities) {
    	for (T t : entities)
    		if (t != null) delete(t);
    }
    
    @Override
    public void deleteAll() {
    	Query query = entityManager.createQuery("DELETE FROM " + entityClass.getName() + " d");
    	LOGGER.debug("deleteAll query: " + query.toString());
		query.executeUpdate();
    }
    
}
