package com.gym.manager;

import java.util.List;
import com.gym.dto.SportDto;

public interface SportManagerService {

	SportDto addSportForGym(SportDto sportDto, Long idGym);
	
	void addSportForSportsMan(long idSport, long idSportsMan);
	
	SportDto editSport(SportDto sportDto, Long id);
	
	void deleteSport(Long id);
	
	SportDto findSportById(Long id);
	
	List<SportDto> findSportsForSportsMan(Long idSportsMan);
	
	List<SportDto> findSportsForGym(Long idGym);
}
