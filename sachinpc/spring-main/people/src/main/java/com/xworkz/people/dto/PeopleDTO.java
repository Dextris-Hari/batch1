package com.xworkz.people.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "people_inf")
public class PeopleDTO implements Serializable {
	public PeopleDTO() {
		System.out.println(" created" + " " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Id
	@GenericGenerator(name = "m" ,strategy = "increment")
	@GeneratedValue(generator = "m")
	private int id;
	private String hesaru;
	private String fileName;

}
