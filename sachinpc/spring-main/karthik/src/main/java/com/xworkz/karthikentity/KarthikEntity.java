package com.xworkz.karthikentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "karthik_detailss")
public class KarthikEntity {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String file;

	public KarthikEntity() {
		super();
		System.out.println(" karthik class is created ");
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	


	

	@Override
	public String toString() {
		return "KarthikEntity [id=" + id + ", file=" + file + "]";
	}

	public KarthikEntity(Integer id, String file) {
		super();
		this.id = id;
		this.file = file;
	}


	
	

}
