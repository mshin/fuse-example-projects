package com.example.jpah.dao;

import java.io.Serializable;

import java.util.List;

public interface BaseDao<T, Id extends Serializable> {

    public <U extends T> void persist(U entity);
    
    public <U extends T> List<U> update(Iterable<U> entities);

    public <U extends T> U update(U entity);
    
    public boolean exists(Id id);

    public <U extends T> U findById(Id id);

    public List<T> findAll();
    
    public List<T> findAll(Iterable<Id> ids);
    
    public int count();

    public void delete(Id id);

    public void delete(T entity);
    
    public void delete(Iterable<? extends T> entities);
    
    public void deleteAll();
}
