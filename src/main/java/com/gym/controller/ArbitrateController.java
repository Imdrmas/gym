package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gym.dto.ArbitrateDto;
import com.gym.manager.ArbitrateManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class ArbitrateController {
	
	@Autowired
	private ArbitrateManagerService arbitrateManagerService;
	
	@PostMapping("/addArbitrateForGym/{idGym}")
	ArbitrateDto addArbitrate(@RequestBody ArbitrateDto arbitrate, @PathVariable long idGym) {
		return arbitrateManagerService.addArbitrateForGym(arbitrate, idGym);
	}
	@PostMapping("/addArbitrateForSport/{idArbitrate}/{idSport}")
	void addArbitrateForSport(@PathVariable long idArbitrate, @PathVariable long idSport) {
	  arbitrateManagerService.addArbitrateForSport(idArbitrate, idSport);
	}
	@PutMapping("/editArbitrate/{id}")
	ArbitrateDto editArbitrate(@RequestBody ArbitrateDto arbitrate, @PathVariable long id) {
		return arbitrateManagerService.editArbitrate(arbitrate, id);
	}
	@DeleteMapping("/deleteArbitrate/{id}")
	void deleteArbitrate(@PathVariable long id) {
		arbitrateManagerService.deleteArbitrate(id);
	}
	@GetMapping("/findAllArbitrates")
	List<ArbitrateDto> findAllArbitrates() {
		return arbitrateManagerService.findAllArbitrates();
	}
	@GetMapping("/findArbitrateById/{id}")
	ArbitrateDto findArbitrateById(@PathVariable long id) {
		return arbitrateManagerService.findArbitrateById(id);
	}
	@GetMapping("/findArbitratesForSport/{idSport}")
	List<ArbitrateDto> findArbitratesForSport(@PathVariable long idSport) {
		return arbitrateManagerService.findArbitratesForSport(idSport);
	}
	@GetMapping("/findArbitratesForGym/{idGym}")
	List<ArbitrateDto> findArbitratesForGym(@PathVariable long idGym) {
		return arbitrateManagerService.findArbitratesForGym(idGym);
	}
}
