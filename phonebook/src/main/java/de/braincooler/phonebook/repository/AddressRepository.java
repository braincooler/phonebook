package de.braincooler.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.braincooler.phonebook.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
