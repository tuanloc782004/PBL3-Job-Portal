package com.jobportal.model;

import java.time.LocalDateTime;

public class Jobs {
    private int id;
    private int idRecruiter;
    private int idCategory;
    private int idLocation;
    private int idType;
    private String salary;
    private String description;
    private String requirement;
    private int vacancy;
    private LocalDateTime postDate;
    private Recruiters recruiter;
    private Categories category;
    private Locations location;
    private Types type;
    private RecruitersDetail recruiterDetail;
    private Confirmations confirmation;
    private Applications application;
    
    public Jobs(int id, int idRecruiter, int idCategory, int idLocation, int idType, String salary, String description,
			String requirement, int vacancy, LocalDateTime postDate, Recruiters recruiter,
			Categories category, Locations location, Types type, RecruitersDetail recruiterDetail,
			Applications application) {
		super();
		this.id = id;
		this.idRecruiter = idRecruiter;
		this.idCategory = idCategory;
		this.idLocation = idLocation;
		this.idType = idType;
		this.salary = salary;
		this.description = description;
		this.requirement = requirement;
		this.vacancy = vacancy;
		this.postDate = postDate;
		this.recruiter = recruiter;
		this.category = category;
		this.location = location;
		this.type = type;
		this.recruiterDetail = recruiterDetail;
		this.application = application;
	}

	public Applications getApplication() {
		return application;
	}

	public void setApplication(Applications application) {
		this.application = application;
	}

	public void setConfirmation(Confirmations confirmation) {
		this.confirmation = confirmation;
	}

	public Confirmations getConfirmation() {
		return confirmation;
	}

	public void setConfirmations(Confirmations confirmation) {
		this.confirmation = confirmation;
	}

	public Jobs(int id, int idRecruiter, int idCategory, int idLocation, int idType, String salary, String description,
			String requirement, int vacancy) {
		super();
		this.id = id;
		this.idRecruiter = idRecruiter;
		this.idCategory = idCategory;
		this.idLocation = idLocation;
		this.idType = idType;
		this.salary = salary;
		this.description = description;
		this.requirement = requirement;
		this.vacancy = vacancy;
	}

    public Jobs(int id, int idRecruiter, int idCategory, int idLocation, int idType, String salary, String description,
			String requirement, int vacancy, LocalDateTime postDate, Recruiters recruiter,
			Categories category, Locations location, Types type, RecruitersDetail recruiterDetail,
			Confirmations confirmations) {
		super();
		this.id = id;
		this.idRecruiter = idRecruiter;
		this.idCategory = idCategory;
		this.idLocation = idLocation;
		this.idType = idType;
		this.salary = salary;
		this.description = description;
		this.requirement = requirement;
		this.vacancy = vacancy;
		this.postDate = postDate;
		this.recruiter = recruiter;
		this.category = category;
		this.location = location;
		this.type = type;
		this.recruiterDetail = recruiterDetail;
		this.confirmation = confirmations;
	}

	public Jobs(int idRecruiter, int idCategory, int idLocation, int idType, String salary, String description,
			String requirement, int vacancy, Recruiters recruiter, Categories category, Locations location, Types type,
			RecruitersDetail recruiterDetail) {
		super();
		this.idRecruiter = idRecruiter;
		this.idCategory = idCategory;
		this.idLocation = idLocation;
		this.idType = idType;
		this.salary = salary;
		this.description = description;
		this.requirement = requirement;
		this.vacancy = vacancy;
		this.recruiter = recruiter;
		this.category = category;
		this.location = location;
		this.type = type;
		this.recruiterDetail = recruiterDetail;
	}

	public RecruitersDetail getRecruiterDetail() {
		return recruiterDetail;
	}

	public void setRecruiterDetail(RecruitersDetail recruiterDetail) {
		this.recruiterDetail = recruiterDetail;
	}

	// Default constructor
    public Jobs() {
        super();
    }

    public Recruiters getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiters recruiter) {
		this.recruiter = recruiter;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public Jobs(String salary, String description, String requirement, int vacancy, LocalDateTime postDate,
			Recruiters recruiter, Categories category, Locations location, Types type) {
		super();
		this.salary = salary;
		this.description = description;
		this.requirement = requirement;
		this.vacancy = vacancy;
		this.postDate = postDate;
		this.recruiter = recruiter;
		this.category = category;
		this.location = location;
		this.type = type;
	}

	// Constructor with all fields including id
    public Jobs(int id, int idRecruiter, int idCategory, int idLocation, int idType, String salary, String description, String requirement, int vacancy, LocalDateTime postDate) {
        super();
        this.id = id;
        this.idRecruiter = idRecruiter;
        this.idCategory = idCategory;
        this.idLocation = idLocation;
        this.idType = idType;
        this.salary = salary;
        this.description = description;
        this.requirement = requirement;
        this.vacancy = vacancy;
        this.postDate = postDate;
    }

    // Constructor without id
    public Jobs(int idRecruiter, int idCategory, int idLocation, int idType, String salary, String description, String requirement, int vacancy, LocalDateTime postDate) {
        super();
        this.idRecruiter = idRecruiter;
        this.idCategory = idCategory;
        this.idLocation = idLocation;
        this.idType = idType;
        this.salary = salary;
        this.description = description;
        this.requirement = requirement;
        this.vacancy = vacancy;
        this.postDate = postDate;
    }

    // Constructor without id, postDate and idPayment
    public Jobs(int idRecruiter, int idCategory, int idLocation, int idType, String salary, String description, String requirement, int vacancy) {
        super();
        this.idRecruiter = idRecruiter;
        this.idCategory = idCategory;
        this.idLocation = idLocation;
        this.idType = idType;
        this.salary = salary;
        this.description = description;
        this.requirement = requirement;
        this.vacancy = vacancy;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRecruiter() {
        return idRecruiter;
    }

    public void setIdRecruiter(int idRecruiter) {
        this.idRecruiter = idRecruiter;
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

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }
}
