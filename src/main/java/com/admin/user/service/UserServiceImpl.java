package com.admin.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.admin.user.model.User;
import com.admin.user.repository.RoleRepository;
import com.admin.user.repository.StateRepository;
import com.admin.user.repository.UserRepository;





@Service(value = "userService")
public class UserServiceImpl implements UserService {

	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private StateRepository stateRepository;

	@Override
	public String save(User user) throws ServiceException {
		log.info("  >>>>>> On save user \n" + user.toString());
		User userFind = userRepository.findByUsername(user.getUsername());
		try {
			if (null ==  userFind) {	
			user.setPassword(passwordEncoder.encode(user.getPassword()));	
			userRepository.save(user);
			return "usuario guardado correcatmente";
			} else {
				throw new ServiceException("El usuario ya existe");
			}

		} catch (Exception e) {
			log.info("El ususario ya existe");
			if(e instanceof ServiceException) {
				throw e;
			}else {
				throw new ServiceException("ocurrio un error al guardar");
			}
		}
		
	}


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
		log.info("  >>>>>> Update User " + user);
		User findToUpdate = userRepository.getFindById(user.getId());
		
		findToUpdate.setIdentificationNumber(user.getIdentificationNumber());
		findToUpdate.setNames(user.getNames());
		findToUpdate.setUsername(user.getUsername());
		findToUpdate.setRoles(user.getRoles());
		
		
		
		return userRepository.save(findToUpdate);
	}

	@Override
	public User findByUsername(String username) throws ServiceException {

		return userRepository.findByUsername(username);
	}

	@Override
	public User getfindById(Long id) throws ServiceException {
	
		return userRepository.findById(id).orElseThrow(() -> new ServiceException("User does not exist"));
	}

	@Override
	public User updatePassword(User user) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
