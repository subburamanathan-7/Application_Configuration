package com.example.applicationConfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.ConfDataModel;
import com.example.applicationConfig.services.ConfDataServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/configdata")
public class ConfDataController {
	
	@Autowired
	private ConfDataServices confDataServices;
	
	
	@GetMapping("/{Id}")
	public ResponseEntity<ConfDataModel> getConfigById(@PathVariable String Id) throws NotFoundException {
		ConfDataModel config  = confDataServices.getConfigData(Id);
		return new ResponseEntity<ConfDataModel>(config,HttpStatus.OK);
	}
	
	@PostMapping("/addConfigData")
	public ResponseEntity<ConfDataModel> newConfig(@RequestBody ConfDataModel config) throws AlreadyExistsException{
		ConfDataModel newConfig  = confDataServices.addConfigData(config);
		return new ResponseEntity<ConfDataModel>(newConfig,HttpStatus.CREATED);
	}

}
