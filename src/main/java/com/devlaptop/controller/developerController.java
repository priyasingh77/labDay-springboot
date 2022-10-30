package com.devlaptop.controller;
//importing required packages
import java.util.List;

import com.devlaptop.model.developer;
import com.devlaptop.service.developerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//RestController is used for making restful web services with the help of the @RestController annotation
@RestController
public class developerController {
	
	//creating dependency injection for service 
	@Autowired
	private developerService service;
	
	//Mapping Method 1-> To  Add developer in DATABASE
	@PostMapping("/developer")
	public ResponseEntity<String>addDevelopar(@RequestBody developer d1){
		String status=service.addDeveloer(d1);
		
		if (status!=null) {
			return new ResponseEntity<>(status,HttpStatus.CREATED);	
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Mapping Method 2->  To Retrieve all Developers
	@GetMapping("/developer")
	public ResponseEntity<List<developer>>getAllDevs(){
		
		return new ResponseEntity<>(service.getAllDevs(),HttpStatus.OK);
		
	}
	// Mapping Method 3->  api to update the developer
	@PutMapping ("/developer")
	public ResponseEntity<String> updateDeveloper(@RequestBody developer d1){
		
		String status =service.updateDeveloper(d1);
		if (status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Mapping Method 4-> api to delete the developer
	@DeleteMapping("/developer/{devid}")
	public ResponseEntity<String> deleteDeveloper(@PathVariable int devid){
		String status =service.deleteDeveloper(devid);
		if (status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

