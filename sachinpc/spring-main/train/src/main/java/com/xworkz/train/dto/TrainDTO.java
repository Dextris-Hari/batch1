package com.xworkz.train.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name ="train_details")
@NamedQueries({@NamedQuery(name = "find",query = "select info from TrainDTO info"),
	@NamedQuery(name = "findByName",query = "select info from TrainDTO info where info.trainName=:tn ")})
public class TrainDTO  implements Serializable{
	
	
	public TrainDTO() {
		System.out.println(" Train DTO is created "+ this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
	@Id
	@GenericGenerator(name = "man", strategy = "increment")
	@GeneratedValue(generator = "man")
	private Integer id;
	private String trainName;
	@Transient
	private MultipartFile image;

	
	
	
	

}
