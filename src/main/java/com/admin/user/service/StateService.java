package com.admin.user.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.admin.user.model.State;

public interface StateService {
	
	State save(State state) throws ServiceException;
	
	List<State> findAll() throws ServiceException;
	
	boolean delete(Long id) throws ServiceException;
	
	State update(State state) throws ServiceException;
	
	State findByName(String name) throws ServiceException;
	
	State findById(Long id) throws ServiceException;

}
