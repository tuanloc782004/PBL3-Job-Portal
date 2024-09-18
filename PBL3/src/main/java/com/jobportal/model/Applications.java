package com.jobportal.model;

import java.time.LocalDateTime;

public class Applications {
	
	private int id;
	private int idJob;
	private int idUser;
	LocalDateTime applyDate;
	private int idConfirmation;
	private Jobs job;
	private Users user;
	private Confirmations confirmation;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public LocalDateTime getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDateTime applyDate) {
		this.applyDate = applyDate;
	}

	public int getIdConfirmation() {
		return idConfirmation;
	}

	public void setIdConfirmation(int idConfirmation) {
		this.idConfirmation = idConfirmation;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Confirmations getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Confirmations confirmation) {
		this.confirmation = confirmation;
	}

	public Applications(int id, int idJob, int idUser, LocalDateTime applyDate, int idConfirmation, Jobs job,
			Users user, Confirmations confirmation) {
		super();
		this.id = id;
		this.idJob = idJob;
		this.idUser = idUser;
		this.applyDate = applyDate;
		this.idConfirmation = idConfirmation;
		this.job = job;
		this.user = user;
		this.confirmation = confirmation;
	}

	public Applications(int id, int idJob, int idUser, LocalDateTime applyDate, int idConfirmation) {
		super();
		this.id = id;
		this.idJob = idJob;
		this.idUser = idUser;
		this.applyDate = applyDate;
		this.idConfirmation = idConfirmation;
	}

	public Applications(int id, int idJob, int idUser, int idConfirmation) {
		super();
		this.id = id;
		this.idJob = idJob;
		this.idUser = idUser;
		this.idConfirmation = idConfirmation;
	}

	public Applications(int idJob, int idUser, int idConfirmation) {
		super();
		this.idJob = idJob;
		this.idUser = idUser;
		this.idConfirmation = idConfirmation;
	}

	public Applications() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
