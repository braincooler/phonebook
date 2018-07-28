package de.braincooler.phonebook.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.braincooler.phonebook.dto.HumanDto;

@Entity
public class Human {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	
	private String secondname;
	
	private Date bday;
	
	private String email;
	
	@OneToOne(orphanRemoval = true)
	@MapsId
	private Address address;
	
	@OneToMany(mappedBy = "human",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Phonenumber> phonenumbers;

	public Human() {
		super();
	}
	
	public Human(HumanDto humanDto) {
		super();
		this.firstname = humanDto.getFirstname();
		this.secondname = humanDto.getSecondname();
		this.bday = humanDto.getBday();
		this.email = humanDto.getEmail();
	}

	public void addPhonenumber(Phonenumber phonenumber) {
		phonenumbers.add(phonenumber);
		phonenumber.setHuman(this);
	}
	
	public void removePhonenumber(Phonenumber phonenumber) {
		phonenumbers.remove(phonenumber);
		phonenumber.setHuman(null);
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Phonenumber> getPhonenumbers() {
		return phonenumbers;
	}

	public void setPhonenumbers(List<Phonenumber> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
}
