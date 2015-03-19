package com.example.jpah.dao;

import org.springframework.stereotype.Repository;
import com.example.jpah.model.User;

/*
 * @Repository enables @PersistenceContext to find the EntityManager inherited from JpaBaseDao.
 */
@Repository("userDao")

public class UserDaoImpl extends JpaBaseDao<User, Integer> implements UserDao {
 
}

