package com.example.applicationConfig;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.applicationConfig.models.RoleModel;
import com.example.applicationConfig.models.UserModel;
import com.example.applicationConfig.repository.RoleRepo;
import com.example.applicationConfig.repository.UserRepo;


@SpringBootApplication

public class ApplicationConfigurationApplication  {
	
	public static void main(String[] args) {
		
		SpringApplication.run(ApplicationConfigurationApplication.class, args);
		System.out.println("Hello");
	}
	
	@Bean
	CommandLineRunner run(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncoder ) {
		
		
		return args->{
			if(roleRepository.findByAuthority("admin").isEmpty()) {
				
				RoleModel adminRole = roleRepository.save(new RoleModel("admin"));
				roleRepository.save(new RoleModel("user"));
				
				Set<RoleModel> roles = new HashSet<>();
				roles.add(adminRole);
				
				UserModel admin = new UserModel("admin", passwordEncoder.encode("password"), roles);
				userRepository.save(admin);
			}
		};
	}
}
