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
import com.gym.dto.SportsManDto;
import com.gym.manager.SportsManManagerService;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class SportsManController {

	@Autowired
	private SportsManManagerService sportsManManagerService;
	
	@PostMapping("/addSportsMan/{id}")
	SportsManDto addSportsMan(@RequestBody SportsManDto sportsMan) {
		return sportsManManagerService.addSportsMan(sportsMan);
	}
	@PutMapping("/editSportsMan/{id}")
	SportsManDto editSportsMan(@RequestBody SportsManDto sportsMan, @PathVariable Long id) {
		return sportsManManagerService.editSportsMan(sportsMan, id);
	}
	@DeleteMapping("/deleteSportsMan/{id}")
	void deleteSportsMan(@PathVariable Long id) {
		sportsManManagerService.deleteSportsMan(id);
	}
	@GetMapping("/findSportsManById/{id}")
	SportsManDto findSportsManById(@PathVariable Long id) {
		return sportsManManagerService.findSportsManById(id);
	}
	@GetMapping("/findAllSportsMans")
	List<SportsManDto> findAllSportsMans() {
		return sportsManManagerService.findAllSportsMans();
	}
}
