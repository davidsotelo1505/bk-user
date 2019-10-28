package com.admin.user.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.admin.user.model.User;

public interface UserService {
	
	User save(User user) throws ServiceException;
	
	List<User> findAll() throws ServiceException;
	
	boolean delete(Long id) throws ServiceException;
	
	User update(User user) throws ServiceException;
	
	User findByUsername(String username) throws ServiceException;
	
	User findById(Long id) throws ServiceException;
	
	User updatePassword(User user) throws ServiceException;
	
	
}
