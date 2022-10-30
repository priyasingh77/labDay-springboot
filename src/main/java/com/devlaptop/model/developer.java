package com.devlaptop.model;
// importing required packages
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class developer {
	// Here The @Id annotation specifies the primary key of an entity
		@Id
		private int developerId;
		private String developerName;
		private String developerRole;
		private String developerPhone;
		//One To Many mapping one developer can have many laptop
		@OneToMany
		@JoinColumn(name="developerId")
		private  List<laptop> devlaptop;
	
	
	
	

}
