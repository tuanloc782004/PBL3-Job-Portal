package com.jobportal.model;

public class Types {
	
	private int id;
	private String name;
	
	public Types() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Types(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Types(String name) {
		super();
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
