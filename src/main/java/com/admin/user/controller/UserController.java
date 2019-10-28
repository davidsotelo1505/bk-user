package com.admin.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Registrar un Usuario en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User user){
		userService.save(user);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(user, status);
		
	}
	
	@ApiOperation(value = "Mostrtar los Usuarios en la platafroma Universidad Libre. Sin Rol Especifico", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUserList() {
		return userService.findAll();
	}
}
