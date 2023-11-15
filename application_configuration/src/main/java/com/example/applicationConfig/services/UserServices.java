package com.example.applicationConfig.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.NotAuthorizedException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.LoginResponseDTO;
import com.example.applicationConfig.models.UserModel;

public interface UserServices extends UserDetailsService{

	UserModel registerUser(UserModel user) throws AlreadyExistsException;
	LoginResponseDTO loginUser(UserModel user) throws NotAuthorizedException, NotFoundException;
}
