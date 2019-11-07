package com.admin.user.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.admin.security.LoginUserDto;
import com.admin.user.model.User;

public interface UserService {
	
	String save(User user) throws ServiceException;
	
	List<User> findAll() throws ServiceException;
	
	boolean delete(Long id) throws ServiceException;
	
	User update(User user) throws ServiceException;
	
	User findByUsername(String username) throws ServiceException;
	
	User getfindById(Long id) throws ServiceException;
	
	User updatePassword(User user) throws ServiceException;
	
	String login(LoginUserDto loginUser) throws ServiceException;
	

	
	
}
