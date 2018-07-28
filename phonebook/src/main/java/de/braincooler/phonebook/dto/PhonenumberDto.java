package de.braincooler.phonebook.dto;

public class PhonenumberDto {

	private Long id;
	
	private String number;

	private Long humanId;
	
	public PhonenumberDto() {
		
	}

	public PhonenumberDto(Long id, String number, Long humanId) {
		super();
		this.id = id;
		this.number = number;
		this.humanId = humanId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getHumanId() {
		return humanId;
	}

	public void setHumanId(Long humanId) {
		this.humanId = humanId;
	}
}
