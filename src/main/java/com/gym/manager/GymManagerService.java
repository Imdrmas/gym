package com.gym.manager;

import java.util.List;

import com.gym.dto.GymDto;

public interface GymManagerService {

	GymDto addGym(GymDto gymDto);
	
	GymDto editGym(GymDto gymDto, Long id);
	
	void deleteGym(Long id);
	
	GymDto findGymById(Long id);
	
	List<GymDto> findAllGyms();
}
