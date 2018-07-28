package de.braincooler.phonebook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.braincooler.phonebook.dto.HumanDto;
import de.braincooler.phonebook.entity.Address;
import de.braincooler.phonebook.entity.Human;
import de.braincooler.phonebook.repository.HumanRepository;

@Service
public class HumanService {

	@Autowired
	private HumanRepository humanRepository;

	public List<HumanDto> findAll() {
		List<Human> humans = humanRepository.findAll();
		return humans.stream()
				.map(h -> convertToDto(h))
				.collect(Collectors.toList());
	}

	public HumanDto save(HumanDto humanDto) {
		Human human = convertToEntity(humanDto);
		return convertToDto(humanRepository.save(human));
	}

	public HumanDto findById(Long humanId) {
		Human human = humanRepository.findById(humanId).get();
		return convertToDto(human);
	}

	public Long deleteHuman(Long humanId) {		
		humanRepository.deleteById(humanId);
		return humanId;
	}
	
	private HumanDto convertToDto(Human human) {
		HumanDto humanDto = new HumanDto(
				human.getId(), 
				human.getFirstname(), 
				human.getSecondname(), 
				human.getBday(), 
				human.getEmail()
				);
		return humanDto;
	}
	
	private Human convertToEntity(HumanDto humanDto) {
		Human human = new Human(humanDto);
		human.setAddress(new Address());

		if(humanDto.getId() != null) {
			Human oldHuman = humanRepository.findById(humanDto.getId()).get();
			human.setId(humanDto.getId());
			human.setAddress(oldHuman.getAddress());
			human.setPhonenumbers(oldHuman.getPhonenumbers());
		}
		return human;
	}
}
