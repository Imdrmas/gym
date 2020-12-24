package com.gym.service;

import com.gym.model.Gym;
import com.gym.model.Sport;

public interface SportService {

	Sport addSport(Sport sport, Gym gym);
	
	Sport editSport(Sport sport, Sport existSport);
	
}
