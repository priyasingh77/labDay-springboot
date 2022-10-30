package com.devlaptop.model;

// importing required package
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class laptop {
	// Here The @Id annotation specifies the primary key of an entity
	@Id
	private int  laptopId;
	private String laptopName;
	private int laptopPrice;
	

}
