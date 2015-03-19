package com.example.jpah.processors;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.cxf.message.MessageContentsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.jpah.dao.*;
import com.example.jpah.model.User;

public class ProcessorBean {

	private static final String CLASS_NAME = ProcessorBean.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	DaoService daoService;

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	
//	public final void afterPropertiesSet() {
//		this.userDao = (UserDao) daoService.getDao(User.class);
//	}
	
	public String create(MessageContentsList mcl) {
		User entity = (User) mcl.get(0);
		
		BaseDao<User, Integer> dao = daoService.getDao(entity);
		//OR
		UserDao userDao = daoService.getUserDao();
		
		dao.persist(entity);
		
		return "Sent out create.";
	}
	
	public User read(MessageContentsList mcl, Exchange exchange) {
		Integer id = (Integer) mcl.get(0);
		
		BaseDao<User, Integer> dao = daoService.getUserDao();
		
		return dao.findById(id);
	}

	public User update(MessageContentsList mcl) {
		User entity = (User) mcl.get(0);

		BaseDao<User, Integer> dao = daoService.getDao(entity);

		return dao.update(entity);
	}
	
	public String delete(MessageContentsList mcl) {
		Integer id = (Integer) mcl.get(0);
		
		UserDao dao = daoService.getUserDao();
		
		dao.delete(id);

		return "Sent out delete.";
	}
	
	public List<User> readAll() {
		
		UserDao dao = daoService.getUserDao();
		return dao.findAll();
	}
}
