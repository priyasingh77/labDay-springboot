package com.devlaptop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.devlaptop.model.developer;
import com.devlaptop.repository.developerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class developerService {
	//creating dependency injection for repository
	@Autowired
	private developerRepository repo;
	
	//adding developer to DB
	public String addDeveloer(developer d1) {
		developer _d2=repo.save(d1);
		
		if(_d2!=null) {
			return "developer added!....@"+new Date();
		}
		else {
			return null;
		}
		
	}
	
	//retriving all developer from DB
	public List<developer>getAllDevs(){
		return repo.findAll();
		//List<developer> devlist=new ArrayList<>();
		
	//	repo.findAll().forEach(devlist::add);
		
		//return devlist;
		
	}
	
	//updating the developer if developer already existed
	public String updateDeveloper(developer d1) {
		developer _d2=repo.save(d1);
		if (_d2!=null) {
			return "developer updated!...."+new Date();
		}
		else {
			return null;
		}
	}
	
	// deleting the developer based on developerId (devid)
	public String deleteDeveloper(int devid){
	
	Optional<developer>_d1=repo.findById(devid);
	
	if(_d1!=null) {
		repo.deleteById(devid);
		return "developer deleted...";
	}
	else {
		return null;
	}
  }

	
	
	
}
