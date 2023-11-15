package com.example.applicationConfig.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.NotAuthorizedException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.LoginResponseDTO;
import com.example.applicationConfig.models.RoleModel;
import com.example.applicationConfig.models.UserModel;
import com.example.applicationConfig.repository.RoleRepo;
import com.example.applicationConfig.repository.UserRepo;

@Service
@Transactional
public class IUserServices implements UserServices {

	@Autowired
	public UserRepo userRepository;
	
	@Autowired
	public RoleRepo roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenServices tokenServices;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws NotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User Not Found"));
	}

	@Override
	public UserModel registerUser(UserModel user) throws AlreadyExistsException {
		
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new  AlreadyExistsException("User already exist");
		}
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		RoleModel userRole = roleRepository.findByAuthority("user").get();
		Set<RoleModel> authorities = new HashSet<>();
		
		authorities.add(userRole);
		return userRepository.save(new UserModel(user.getUsername(), encodedPassword, authorities));
		
	}
	
	@Override
	@Query(fields = "{'username' : 1, 'userId' : 1, 'role' : 1}")
	public LoginResponseDTO loginUser(UserModel user) throws NotAuthorizedException, NotFoundException { 

		try {
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
			);
			String token = tokenServices.generateJWT(auth);
			return new LoginResponseDTO(userRepository.findByUsername(user.getUsername()).get(), token);
					
		}
		catch (AuthenticationException e) {
			// TODO: handle exception
			throw new NotAuthorizedException("User Not Authorized");
		}		
	}
}


//if(!username.equals("shreya" )) {
//	throw new NotFoundException("User not found");
//}
//
//Set<RoleModel> roles = new HashSet<>();
//roles.add(new RoleModel("96","USER"));
//
//
//
//return new UserModel("96","shreya",encoder.encode("password"),roles);





//UserModel existingUser;
//
//if(userRepository.findByUsername(user.getUsername()).isEmpty()) {
//	throw new NotFoundException("User Not Found");
//}
//else{
//	existingUser = userRepository.findByUsername(user.getUsername()).get();
//	if(user.getPassword().equals(existingUser.getPassword())) {
//		throw new NotAuthorizedException("User Not Authorized");
//	}
//}
//return existingUser;
