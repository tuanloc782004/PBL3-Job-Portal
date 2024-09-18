package com.jobportal.model;

public class Locations {

	private int id;
	private String name;
	
	public Locations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Locations(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Locations(String name) {
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
