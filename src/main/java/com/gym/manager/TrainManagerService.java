package com.gym.manager;

import java.util.List;
import com.gym.dto.TrainDto;

public interface TrainManagerService {

	TrainDto addTrainForGym(TrainDto trainDto, long idGym);
	
	void addTrainForSport(long idTrain, long idSport);
	
	TrainDto editTrain(TrainDto trainDto, long id);
	
	void deleteTrain(long id);
	
	TrainDto findTrainById(long id);
	
	List<TrainDto> findAllTrains();
	
	List<TrainDto> findTrainsForSport(long idSport);
	
	List<TrainDto> findTrainsForGym(long idGym);
}
