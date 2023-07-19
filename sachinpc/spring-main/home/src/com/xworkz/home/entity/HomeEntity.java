package com.xworkz.home.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "home_details")
public class HomeEntity {
	@Id
	private Integer id;
	private String homeName;
	private String owner;
	private String type;
	private Integer noOfRooms;
	private Integer noOfDoors;

	public HomeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomeEntity(Integer id, String homeName, String owner, String type, Integer noOfRoom, Integer noOfDoors) {
		super();
		this.id = id;
		this.homeName = homeName;
		this.owner = owner;
		this.type = type;
		this.noOfRooms = noOfRoom;
		this.noOfDoors = noOfDoors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNoOfRoom() {
		return noOfRooms;
	}

	public void setNoOfRoom(Integer noOfRoom) {
		this.noOfRooms = noOfRoom;
	}

	public Integer getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(Integer noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	@Override
	public String toString() {
		return "HomeEntity [id=" + id + ", homeName=" + homeName + ", owner=" + owner + ", type=" + type + ", noOfRoom="
				+ noOfRooms + ", noOfDoors=" + noOfDoors + "]";
	}

}
