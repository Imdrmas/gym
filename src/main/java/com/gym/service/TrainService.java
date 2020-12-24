package com.gym.service;

import com.gym.model.Gym;
import com.gym.model.Train;


public interface TrainService {

	Train addTrainForGym(Train train, Gym gym);
	
	Train editTrain(Train train, Train existsTrain);

}
