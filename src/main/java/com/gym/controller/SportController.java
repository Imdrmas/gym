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
import com.gym.dto.SportDto;
import com.gym.manager.SportManagerService;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class SportController {
 
	@Autowired
	private SportManagerService sportManagerService;
	
	@PostMapping("/addSportForGym/{idGym}")
	SportDto addSportForGym(@RequestBody SportDto sport, @PathVariable Long idGym) {
		return sportManagerService.addSportForGym(sport, idGym);
	}
	
	@PostMapping("/addSportForSportsMan/{idSport}/{idSportsMan}")
	void addSportForSportsMan(@PathVariable long idSport, @PathVariable long idSportsMan) {
		sportManagerService.addSportForSportsMan(idSport, idSportsMan);
	}
	
	@PutMapping("/editSport/{id}")
	SportDto editSport(@RequestBody SportDto sport, @PathVariable Long id) {
		return sportManagerService.editSport(sport, id);
	}
	
	@DeleteMapping("/deleteSport/{id}")
	void deleteSport(@PathVariable Long id) {
		sportManagerService.deleteSport(id);
	}
	
	@GetMapping("/findSportById/{id}")
	SportDto findSportById(@PathVariable Long id) {
		return sportManagerService.findSportById(id);
	}
	
	@GetMapping("/findSportsForSportsMan/{idSportsMan}")
	List<SportDto> findSportsForSportsMan(@PathVariable Long idSportsMan) {
		return sportManagerService.findSportsForSportsMan(idSportsMan);
	}
	
	@GetMapping("/findSportsForGym/{idGym}")
	List<SportDto> findSportsForGym(@PathVariable Long idGym) {
		return sportManagerService.findSportsForGym(idGym);
	}
}
