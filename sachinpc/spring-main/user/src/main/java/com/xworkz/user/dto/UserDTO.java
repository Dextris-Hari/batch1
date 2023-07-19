package com.xworkz.user.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_details")
@NamedQueries({ @NamedQuery(name = "findByMail", query = "select info from UserDTO info where info.mailId=:ml"),
		@NamedQuery(name = "findByEmailAndSecurity", query = "select info from  UserDTO info where info.mailId=:ml and info.security=:sc"),
		@NamedQuery(name = "updateStatusByMail", query = "update  UserDTO info set info.status=:st where info.mailId=:mi"),
		@NamedQuery(name = "updateCountByMail", query = " update UserDTO info set info.count=:cn   where info.mailId=: mi"),
		@NamedQuery(name = "updatePasswardByMail", query = " update  UserDTO info set info.security=:sc where info.mailId=:mi"),
		@NamedQuery(name = "updateOtpDateAndTimeByMail", query = "update UserDTO info set info.otp=:otp,info.date=:date,info.time=:time where info.mailId=:mi") ,
		@NamedQuery(name = "resetPasswordByEmail",query = " update  UserDTO info set info.otp=:otp,info.security=:security , info.status=:st, info.conformPassward=:cp where info.mailId=:mi"),
		@NamedQuery(name = "updateNameAndPhoneNumberBymail",query = "update UserDTO info set info.name=:name,info.phoneNumber=:pn,info.fileName=:fn where info.mailId=:mail")})
public class UserDTO {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String name;
	@Column(name = "email")
	private String mailId;
	private Long phoneNumber;

	private String fileName;
	@Column(name = "passward")
	private String security;
	private String status;
	private String conformPassward;
	private Integer count;
	private Integer otp;
	private LocalDate date;
	private LocalTime time;

	public UserDTO() {
		super();
		System.out.println(" created UserDTO");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", mailId=" + mailId + ", phoneNumber=" + phoneNumber
				+ ", fileName=" + fileName + ", security=" + security + ", status=" + status + ", conformPassward="
				+ conformPassward + ", count=" + count + ", otp=" + otp + ", date=" + date + ", time=" + time + "]";
	}

	public UserDTO(Integer id, String name, String mailId, Long phoneNumber, String fileName, String security,
			String status, String conformPassward, Integer count, Integer otp, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.name = name;
		this.mailId = mailId;
		this.phoneNumber = phoneNumber;
		this.fileName = fileName;
		this.security = security;
		this.status = status;
		this.conformPassward = conformPassward;
		this.count = count;
		this.otp = otp;
		this.date = date;
		this.time = time;
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
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConformPassward() {
		return conformPassward;
	}

	public void setConformPassward(String conformPassward) {
		this.conformPassward = conformPassward;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	
}
