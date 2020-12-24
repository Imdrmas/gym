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

import com.gym.dto.GymDto;
import com.gym.manager.GymManagerService;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class GymController {
 
	@Autowired
	private GymManagerService gymManagerService;
	
	@PostMapping("/addGym")
	GymDto addGym(@RequestBody GymDto gym) {
		return gymManagerService.addGym(gym);
	}
	@PutMapping("/editGym/{id}")
	GymDto editGym(@RequestBody GymDto gym, @PathVariable Long id) {
		return gymManagerService.editGym(gym, id);
	}
	@DeleteMapping("/deleteGym/{id}")
	void deleteGym(@PathVariable Long id) {
		gymManagerService.deleteGym(id);
	}
	@GetMapping("/findGymById/{id}")
	GymDto findGymById(@PathVariable Long id) {
		return gymManagerService.findGymById(id);
	}
	@GetMapping("/findAllGyms")
	List<GymDto> findAllGyms() {
		return gymManagerService.findAllGyms();
	}
}
