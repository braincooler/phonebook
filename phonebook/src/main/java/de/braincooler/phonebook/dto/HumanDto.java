package de.braincooler.phonebook.dto;

import java.util.Date;

public class HumanDto {
	
	private Long id;
	
	private String firstname;

	private String secondname;
	
	private Date bday;
	
	private String email;
	
	public HumanDto() {
		
	}

	public HumanDto(Long id, String firstname, String secondname, Date bday, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.secondname = secondname;
		this.bday = bday;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "HumanDto [id=" + id + ", firstname=" + firstname + ", secondname=" + secondname + ", bday=" + bday
				+ ", email=" + email + "]";
	}
}
