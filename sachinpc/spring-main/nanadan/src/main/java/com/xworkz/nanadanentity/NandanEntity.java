package com.xworkz.nanadanentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nandu")

public class NandanEntity {
	@Id
	private Integer id;
	//@Value(value="name")
	private String name;
	private String fatherName;
	public NandanEntity(Integer id, String name, String fatherName) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
	}
	
	
	
	

}
