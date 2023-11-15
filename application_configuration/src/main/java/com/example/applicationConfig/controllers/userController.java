package com.example.applicationConfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.NotAuthorizedException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.LoginResponseDTO;
import com.example.applicationConfig.models.UserModel;
import com.example.applicationConfig.services.UserServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class userController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/register")
	public ResponseEntity<UserModel> newUser(@RequestBody UserModel user) throws AlreadyExistsException{
		UserModel newUser  = userServices.registerUser(user);
		return new ResponseEntity<UserModel>(newUser,HttpStatus.CREATED);
	}

	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> existingUser(@RequestBody UserModel user) throws NotAuthorizedException, NotFoundException{
		LoginResponseDTO existingUser = userServices.loginUser(user);
		return new ResponseEntity<LoginResponseDTO>(existingUser,HttpStatus.ACCEPTED);
	}
}
