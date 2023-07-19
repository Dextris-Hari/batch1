package com.xworkz.booklist.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "booklist_details")
@NamedQueries({@NamedQuery(name = "find", query = "select info from BookListDTO info "),
	@NamedQuery(name = "findByName",query = "select info from BookListDTO info where info.name=:nm")})
public class BookListDTO implements Serializable {
	public BookListDTO() {
		System.out.println("nanu booklist " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Id
	@GenericGenerator(name = "man", strategy = "increment")
	@GeneratedValue(generator = "man")
	private Integer id;
	private String name;

}
