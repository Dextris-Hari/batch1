package com.xworkz.criminals.dto;

import java.io.Serializable;
import java.util.jar.Attributes.Name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "criminals_details")
@NamedQueries({@NamedQuery(name="findAll",query="select info from CriminalsDTO info"),
	@NamedQuery(name = "findByName", query = "select info from CriminalsDTO info where info.name=:nm")})
public class CriminalsDTO implements Serializable {

	public CriminalsDTO() {
		System.out.println(" nanu criminalDTO" + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
    @Id
    @GenericGenerator(name = "m",strategy = "increment")
    @GeneratedValue(generator = "m")
	private Integer id;
    private String name;
	private Integer age;
	private String country;
	private String type;
	private Integer noOfCase;
	private String alive;
	private String gender;
	private String international;
	private String married;
	private Double jailTerm;
	private String wifeName;
	private String rightHand;
	private String leftHand;
	private String jailName;
	private double netWorth;

}
