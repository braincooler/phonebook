package de.braincooler.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.braincooler.phonebook.entity.Human;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {

}
