package com.devlaptop.controller;
// importing required packages
import java.util.List;

import com.devlaptop.model.laptop;
import com.devlaptop.service.laptopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//RestController is used for making restful web services with the help of the @RestController annotation
@RestController
public class laptopController {
	
		//creating dependency injection for service 
		@Autowired 
		private laptopService service;
		
		// to add the laptop in DB
		@RequestMapping(method=RequestMethod.POST,value="/laptop")
		public ResponseEntity<String>addlaptop(@RequestBody laptop l1 ) {
			 String status=service.addLaptop(l1);
			 if(status!=null)
				 return new ResponseEntity<>(status,HttpStatus.CREATED);
			 else
				 return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		//retrieve List of laptop from Database
		@RequestMapping(method=RequestMethod.GET,value="/laptop")
		public ResponseEntity<List<laptop>> getLaptop(){
			return new ResponseEntity<>(service.getAllLaptops(),HttpStatus.OK);

		}
		// Mehtod to update the laptop 
		@RequestMapping(method=RequestMethod.PUT,value="/laptop")
		public ResponseEntity<String> updateLaptop(@RequestBody laptop l1 ) {
			 String status=service.updateLaptop(l1);
			 if(status!=null)
				 return new ResponseEntity<>(status,HttpStatus.OK);
			 else
				 return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		//Method to delete the laptop 
		@RequestMapping(method=RequestMethod.DELETE,value="/laptop/{lapid}")
		public ResponseEntity<String>deleteLaptop(@PathVariable int lapid ) {
			 String status=service.deleteLaptop(lapid);
			 if(status!=null)
				 return new ResponseEntity<>(status,HttpStatus.OK);
			 else
				 return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		// Mapping Method>> to sort the laptop according the specific field
		@GetMapping("/getlaptops/{field}")
		public ResponseEntity<List<laptop>>getLaptops (@PathVariable String field) {
			
			return new  ResponseEntity<>(service.getLaptops(field),HttpStatus.OK);
		}
	
	
	
	
	
}
