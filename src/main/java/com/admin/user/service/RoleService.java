package com.admin.user.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.admin.user.model.Role;

public interface RoleService {
	
	Role save(Role roleDto) throws ServiceException;
	
	List<Role> findAll() throws ServiceException;
	
	boolean delete(Long id) throws ServiceException;
	
	Role update(Role role) throws ServiceException;
	
	Role findByName(String name) throws ServiceException;
	
	Role findById(Long id) throws ServiceException;
}
