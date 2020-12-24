package com.gym.service;
import com.gym.model.Gym;

public interface GymService {

	Gym addGym(Gym gym);
	
	Gym editGym(Gym gym, Gym existsGym);

}
