package com.devlaptop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.devlaptop.model.laptop;
import com.devlaptop.repository.laptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class laptopService {
	
	//creating dependency injection for repository
	@Autowired
	private laptopRepository laprepo;
	
	//Method to add laptop list in Db
	public String addLaptop(laptop l1){
		
		String msg=null;           
		laptop _l2=laprepo.save(l1);
		if (_l2!=null) {
			msg="laptop Added!... @"+new Date();
		}
		else {
			msg=null;
		}
		return msg ;
	}
	
	//Method to retrive  laptop list form DB
	public List<laptop> getLaptop(){
		return laprepo.findAll();
	}
	
	// Method to updating the existing laptop in DB
	public String updateLaptop(laptop l1) {
		
		laptop _l2=laprepo.save(l1);
		if(_l2!=null) {
			return "laptop updated Successfully"+new Date();
		}
		else {
			return null;
		}
	}
	// Delete laptop based on laptopid(lapid) if it is existed in DB
	public String deleteLaptop(int lapid) {
		
		Optional<laptop> _l1=laprepo.findById(lapid);
		
		if(_l1!=null) {
			laprepo.deleteById(lapid);
			return "laptop deleted...";
		}
		else {
			return null;
		}
	}
	
	//sorting the list of laptop based on a specific field of table
	public List<laptop> getLaptops(String field){
		return laprepo.findAll(Sort.by(Direction .DESC,field));
	}

}
