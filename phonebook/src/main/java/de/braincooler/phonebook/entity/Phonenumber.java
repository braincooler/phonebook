package de.braincooler.phonebook.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phonenumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "human_id")
	private Human human;

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

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}
	 /*
	  The child entity, PostComment, implement the equals and hashCode methods. 
	  Since we cannot rely on a natural identifier for equality checks, we need to use the entity identifier instead. 
	  However, you need to do it properly so that equality is consistent across all entity state transitions.
	  Because we rely on equality for the 'removePhonenumber', it’s good practice to override equals and hashCode 
	  for the child entity in a bidirectional association.
	  https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
	  */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phonenumber )) return false;
        return id != null && id.equals(((Phonenumber) o).id);
    }
	
    @Override
    public int hashCode() {
        return 31;
    }
}
