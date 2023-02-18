package com.Excel;

public class Object {
	
	String attribute;
	String entity;
	String datatype;
	String description;
	public Object(String attribute, String entity, String datatype, String description) {
		super();
		this.attribute = attribute;
		this.entity = entity;
		this.datatype = datatype;
		this.description = description;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}
