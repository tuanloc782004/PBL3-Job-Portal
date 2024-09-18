package com.jobportal.model;

public class UsersDetail {
	
	private int idUser;
	private int idCategory;
	private int idLocation;
	private String workExperience;
	private String education;
	private String professionalSkills;
	private String img;
	
	public UsersDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersDetail(int idUser, int idCategory, int idLocation, String workExperience, String education,
			String professionalSkills, String img) {
		super();
		this.idUser = idUser;
		this.idCategory = idCategory;
		this.idLocation = idLocation;
		this.workExperience = workExperience;
		this.education = education;
		this.professionalSkills = professionalSkills;
		this.img = img;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getProfessionalSkills() {
		return professionalSkills;
	}

	public void setProfessionalSkills(String professionalSkills) {
		this.professionalSkills = professionalSkills;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
