package de.braincooler.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.braincooler.phonebook.dto.HumanDto;
import de.braincooler.phonebook.service.HumanService;

@Controller
@RequestMapping(value = "humans")
public class HumanController {

	@Autowired
	private HumanService humanService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getHumans() {
		List<HumanDto> humans = humanService.findAll();
		return ResponseEntity.ok(humans);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> storeHuman(@RequestBody HumanDto human) {	
		return ResponseEntity.ok(humanService.save(human));
	}

	@RequestMapping(value = "/{humanId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getHuman(@PathVariable Long humanId) {
		HumanDto human = humanService.findById(humanId);
		return ResponseEntity.ok(human);
	}
	
	@DeleteMapping(value = "/{humanId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteHuman(@PathVariable Long humanId){
		return ResponseEntity.ok(humanService.deleteHuman(humanId));
	}
}
