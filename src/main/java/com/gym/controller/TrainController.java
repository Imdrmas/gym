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
import com.gym.dto.TrainDto;
import com.gym.manager.TrainManagerService;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class TrainController {

	@Autowired
	private TrainManagerService trainManagerService;
	
	@PostMapping("/addTrainForGym/{idGym}")
	TrainDto addTrainForGym(@RequestBody TrainDto train, @PathVariable long idGym) {
		return trainManagerService.addTrainForGym(train, idGym);
	}
	@PostMapping("/addTrainForSport/{idTrain}/{idSport}")
	void addTrainForSport(@PathVariable long idTrain, @PathVariable long idSport) {
	  trainManagerService.addTrainForSport(idTrain, idSport);
	}
	@PutMapping("/editTrain/{id}")
	TrainDto editTrain(@RequestBody TrainDto train, @PathVariable long id) {
		return trainManagerService.editTrain(train, id);
	}
	@DeleteMapping("/deleteTrain/{id}")
	void deleteTrain(@PathVariable long id) {
		trainManagerService.deleteTrain(id);
	}
	@GetMapping("/findTrainById/{id}")
	TrainDto findTrainById(@PathVariable long id) {
		return trainManagerService.findTrainById(id);
	}
	@GetMapping("/findAllTrains")
	List<TrainDto> findAllTrains() {
		return trainManagerService.findAllTrains();
	}
	@GetMapping("/findTrainsForSport/{idSport}")
	List<TrainDto> findTrainsForSport(@PathVariable long idSport) {
		return trainManagerService.findTrainsForSport(idSport);
	}
	
	@GetMapping("/findTrainsForGym/{idGym}")
	List<TrainDto> findTrainsForGym(@PathVariable long idGym) {
		return trainManagerService.findTrainsForGym(idGym);
	}
}
