package com.example.applicationConfig.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applicationConfig.exceptions.AlreadyExistsException;
import com.example.applicationConfig.exceptions.NotFoundException;
import com.example.applicationConfig.models.ConfModel;
import com.example.applicationConfig.services.ConfServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/config")
public class confController {
	
	@Autowired
	private ConfServices confServices;
	
	@GetMapping("/demo")
	public String getInit() {
		return ("hello shreya");
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<ConfModel>> getConfigs() throws NotFoundException{
		List <ConfModel> configs = confServices.getAllConfigs();
		return new ResponseEntity<>(configs,HttpStatus.OK);
	}

	@GetMapping("/{Id}")
	public ResponseEntity<ConfModel> getConfigById(@PathVariable String Id) throws NotFoundException {
		ConfModel config  = confServices.getConfig(Id);
		return new ResponseEntity<ConfModel>(config,HttpStatus.OK);
	}
	
	@PostMapping("/createConfig")
	public ResponseEntity<ConfModel> newConfig(@RequestBody ConfModel config) throws AlreadyExistsException{
		ConfModel newConfig  = confServices.addConfig(config);
		return new ResponseEntity<ConfModel>(newConfig,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateConfig/{Id}")
	public ResponseEntity<ConfModel> updateConfig(@PathVariable String Id, @RequestBody ConfModel config) throws NotFoundException{
		ConfModel updatedConfig  = confServices.updateConfig(Id,config);
		return new ResponseEntity<ConfModel>(updatedConfig,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteConfig/{Id}")
	public ResponseEntity<ConfModel> deleteConfig(@PathVariable String Id) throws NotFoundException{
		ConfModel deletedConfig  = confServices.deleteConfig(Id);
		return new ResponseEntity<ConfModel>(deletedConfig,HttpStatus.OK);
	}
}
