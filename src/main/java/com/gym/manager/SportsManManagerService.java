package com.gym.manager;

import java.util.List;
import com.gym.dto.SportsManDto;


public interface SportsManManagerService {

	SportsManDto addSportsMan(SportsManDto sportsManDto);
	
	SportsManDto editSportsMan(SportsManDto sportsManDto, Long id);
	
	void deleteSportsMan(Long id);
	
	SportsManDto findSportsManById(Long id);
	
	List<SportsManDto> findAllSportsMans();
}
