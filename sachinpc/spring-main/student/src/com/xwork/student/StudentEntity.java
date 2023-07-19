package com.xwork.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student_details")
public class StudentEntity {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	
	//@Column(name = "id")
	private int id;
	///@Column(name = "name")
	
	private String name;
	//@Column(name = "fatherName")
	private String fatherName;
	//@Column(name = "motherName")
	private String motherName;
	

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEntity( String name, String fatherName, String motherName) {
		super();
		//this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	/*
	 * public int getId() { return id; }
	 */

	/*
	 * public void setId(int id) { this.id = id; }
	 */
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", motherName="
				+ motherName + "]";
	}

}
