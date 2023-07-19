package com.xworkz.foodandmusic.dto;

import java.io.Serializable;

public class MusicDTO  implements Serializable{
	public MusicDTO() {
		System.out.println("MusicDTO is created "+ this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String singer;
	private int duration;
	private String producer;
	private String lyrics;
	private String longuage;
	private String type;
	@Override
	public String toString() {
		return "MusicDTO [name=" + name + ", singer=" + singer + ", duration=" + duration + ", producer=" + producer
				+ ", lyrics=" + lyrics + ", longuage=" + longuage + ", type=" + type + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public String getLonguage() {
		return longuage;
	}
	public void setLonguage(String longuage) {
		this.longuage = longuage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
