package com.xworkz.user1.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User1 {
	private Integer id;
	private String name;
	private String mailId;
	private Long PhoneNumber;

	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User1(Integer id, String name, String mailId, Long phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.mailId = mailId;
		PhoneNumber = phoneNumber;
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User1 [id=" + id + ", name=" + name + ", mailId=" + mailId + ", PhoneNumber=" + PhoneNumber + "]";
	}

}
