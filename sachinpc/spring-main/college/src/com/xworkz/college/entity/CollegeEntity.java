package com.xworkz.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "college_details")
public class CollegeEntity {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")

	/*
	 * @Id
	 * 
	 * @GenericGenerator(name = "m", strategy = " increment")
	 * 
	 * @GeneratedValue(generator = "m")
	 */
	private Integer id;
	private String name;
	private Integer noOfStudent;

	public CollegeEntity() {
		super();
		System.out.println(" entity class is created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNoOfStudent() {
		return noOfStudent;
	}

	public void setNoOfStudent(Integer noOfStudent) {
		this.noOfStudent = noOfStudent;
	}

	@Override
	public String toString() {
		return "CollegeEntity [id=" + id + ", name=" + name + ", noOfStudent=" + noOfStudent + "]";
	}

	public CollegeEntity(String name, Integer noOfStudent) {
		super();

		this.name = name;
		this.noOfStudent = noOfStudent;
	}

}
