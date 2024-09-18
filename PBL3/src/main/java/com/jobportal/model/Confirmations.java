package com.jobportal.model;

public class Confirmations {
	
	private int id;
	private String name;
	
	public Confirmations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Confirmations(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Confirmations(String name) {
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
