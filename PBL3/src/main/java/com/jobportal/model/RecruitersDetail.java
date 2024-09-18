package com.jobportal.model;

public class RecruitersDetail {

	private int idRecruiter;
	private String description;
	private int idCountry;
	private String web;
	private String img;
	public RecruitersDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecruitersDetail(int idRecruiter, String description, int idCountry, String web, String img) {
		super();
		this.idRecruiter = idRecruiter;
		this.description = description;
		this.idCountry = idCountry;
		this.web = web;
		this.img = img;
	}
	public int getIdRecruiter() {
		return idRecruiter;
	}
	public void setIdRecruiter(int idRecruiter) {
		this.idRecruiter = idRecruiter;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}