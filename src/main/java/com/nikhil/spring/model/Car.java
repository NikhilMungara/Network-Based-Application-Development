package com.nikhil.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	private int cid;
	private String cmodel;
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCmodel() {
		return cmodel;
	}
	public void setCmodel(String cmodel) {
		this.cmodel = cmodel;
	}
	
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cmodel=" + cmodel + ", type=" + type + "]";
	}
	
	
	
}
