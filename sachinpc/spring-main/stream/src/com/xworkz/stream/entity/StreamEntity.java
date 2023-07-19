package com.xworkz.stream.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "stream_details")
public class StreamEntity implements Cloneable, Serializable {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String name;
	private String wifeName;
	private String fatherName;
	private Long phoneNumber;
	private Integer adarNo;
	private String PanNo;

	public StreamEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StreamEntity(String name, String wifeName, String fatherName, Long phoneNumber, Integer adarNo,
			String panNo) {
		super();

		this.name = name;
		this.wifeName = wifeName;
		this.fatherName = fatherName;
		this.phoneNumber = phoneNumber;
		this.adarNo = adarNo;
		PanNo = panNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getAdarNo() {
		return adarNo;
	}

	public void setAdarNo(Integer adarNo) {
		this.adarNo = adarNo;
	}

	public String getPanNo() {
		return PanNo;
	}

	public void setPanNo(String panNo) {
		PanNo = panNo;
	}

}
