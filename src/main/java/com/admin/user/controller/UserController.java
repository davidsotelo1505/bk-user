package com.admin.user.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.security.LoginUserDto;
import com.admin.user.model.User;
import com.admin.user.service.UserService;
import com.admin.util.GeneralResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "adminuser", description = "Operaciones correspondientes a la gestión de usuarios de las plataformas Universidad Libre")
@RestController
@RequestMapping("/users")
public class UserController {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@ApiOperation(value = "Registrar un Usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<User>> saveUser(@RequestBody User user) {
		GeneralResponse<User> response = new GeneralResponse<>();
		HttpStatus status = HttpStatus.OK;
		try {
			
			validateUsername(user.getUsername());
			validatePassword(user.getPassword());
			User userSaved = userService.save(user);
			//response.setData(userSaved);
			response.setUser_id(user.getId());
			response.setSuccess(true);
			response.setMessage("Usuario guardado exitosamente");
			response.setRol(user.getRol());
			status = HttpStatus.OK;
	
		} catch (Exception e) {

			status = HttpStatus.BAD_REQUEST;
			response.setSuccess(false);
			response.setMessage("usuario ya existe");
			

		}return new ResponseEntity<GeneralResponse<User>>(response, status);

	}

	@ApiOperation(value = "Mostrtar los Usuarios en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<User> getUserList() {
		return userService.findAll();
	}

	@ApiOperation(value = "BUscar por id el usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<User> getUserById(@PathVariable(name = "id")Long id) {
		User user =userService.getfindById(id);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<User>(user, status);
	}
	
	@ApiOperation(value = "Registrar un Usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<User>> updateUser(@RequestBody User user){
		GeneralResponse<User> response = new GeneralResponse<>();
		log.info(" Init updateUser");
		
		User userUpdate = userService.update(user);
		response.setSuccess(true);
		response.setMessage("Usuario actualizado exitosamente");
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<GeneralResponse<User>>(response, status);
	}
	

	@ApiOperation(value = "Generar token de accesso a la plataforma Virgin Mobile. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<GeneralResponse<User>> loginUser(@RequestBody LoginUserDto loginUser){
		GeneralResponse<User> response = new GeneralResponse<>();
		try {
			validateUsername(loginUser.getUsername());
			validatePassword(loginUser.getPassword());
			response.setMessage(userService.login(loginUser));
			User user = userService.findByUsername(loginUser.getUsername());
			response.setUser_id(user.getId());
			response.setSuccess(true);
			response.setRol(user.getRol());
			HttpStatus status = HttpStatus.OK;
			return new ResponseEntity<GeneralResponse<User>>(response, status);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Usuario no existe");
			HttpStatus status = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<GeneralResponse<User>>(response, status);

		}
		

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
