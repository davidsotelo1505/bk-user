package com.admin.user.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.user.model.User;
import com.admin.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "adminuser", description = "Operaciones correspondientes a la gestión de usuarios de las plataformas Universidad Libre")
@RestController
@RequestMapping("/users")
public class UserController {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Registrar un Usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			validateUsername(user.getUsername());
			validatePassword(user.getPassword());
			HttpStatus status = HttpStatus.OK;
			return new ResponseEntity<String>(userService.save(user), status);
		} catch (Exception e) {

			HttpStatus status = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<String>(e.getMessage(), status);

		}

	}

	@ApiOperation(value = "Mostrtar los Usuarios en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUserList() {
		return userService.findAll();
	}

	@ApiOperation(value = "BUscar por id el usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable(name = "id")Long id) {
		User user =userService.getfindById(id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<User>(user, status);
	}
	
	@ApiOperation(value = "Registrar un Usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user){
		log.info(" Init updateUser");
		HttpStatus status = HttpStatus.OK;
		User userUpdate = userService.update(user);
		return new ResponseEntity<User>(userUpdate, status);
	}

	public void validateUsername(String username) throws ServiceException {
		if (username == null || username.isEmpty()) {
			throw new ServiceException("Usuario es requerido");
		}
	}

	public void validatePassword(String password) throws ServiceException {
		if (password == null || password.isEmpty()) {
			throw new ServiceException("Password es requerido");
		}
	}
}
