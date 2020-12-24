package com.gym.manager;

import java.util.List;
import com.gym.dto.ArbitrateDto;

public interface ArbitrateManagerService {
	
	void addArbitrateForSport(long idArbitrate, long idSport);
	
	ArbitrateDto addArbitrateForGym(ArbitrateDto arbitrateDto, long idGym);
	
	ArbitrateDto editArbitrate(ArbitrateDto arbitrateDto, long id);
	
	void deleteArbitrate(long id);
	
	ArbitrateDto findArbitrateById(long id);
	
	List<ArbitrateDto> findArbitratesForSport(long idSport);
	
	List<ArbitrateDto> findArbitratesForGym(long id);
	
	List<ArbitrateDto> findAllArbitrates();
}
