package com.admin.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.admin.user.model.User;
import com.admin.user.repository.RoleRepository;
import com.admin.user.repository.StateRepository;
import com.admin.user.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private StateRepository stateRepository;
	

	@ApiOperation(value = "guarda los usuarios en el sistema.", response = ResponseEntity.class)
	@Override
	public User save(User user) throws ServiceException {
		log.info("  >>>>>> On save user \n" + user.toString());

		return userRepository.save(user);
	}
	
	@ApiOperation(value = "Obtiene los usuarios existentes en el sistema.", response = ResponseEntity.class)
	@Override
	public List<User> findAll() throws ServiceException {
		log.info("  >>>>>> On findAll User");
		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();
		return userList;
	}

	@Override
	public boolean delete(Long id) throws ServiceException {
		log.info("  >>>>>> On delete User " + id);
		boolean flag = false;
		try {
			Optional<User> userO = userRepository.findById(id);
			User user = userO.get();
			userRepository.delete(user);
			flag = true;
		} catch (Exception e) {
			log.error("  xxxxxx Exception in delete User " + id);
		}
		
		
		return flag;
	}

	@Override
	public User update(User user) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatePassword(User user) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
