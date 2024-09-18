package com.jobportal.model;

public class Categories {

	private int id;
	private String name;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categories(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Categories(String name) {
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
