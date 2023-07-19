package com.xworkz.cinimacom.xworkz.cinimaentity;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="cinima")
public class CinimaEntity {
	private String createby;
	private String updateby;
	public CinimaEntity(String createby, String updateby) {
		super();
		this.createby = createby;
		this.updateby = updateby;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public String getUpdateby() {
		return updateby;
	}
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	@Override
	public String toString() {
		return "CinimaEntity [createby=" + createby + ", updateby=" + updateby + "]";
	}
	
	

}
