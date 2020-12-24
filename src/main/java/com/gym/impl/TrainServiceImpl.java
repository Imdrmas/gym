package com.gym.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gym.dao.TrainDao;
import com.gym.model.Gym;
import com.gym.model.Train;
import com.gym.service.TrainService;

@Component
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDao trainDao;
	
	@Override
	public Train addTrainForGym(Train train, Gym gym) {
		gym.addTrain(train);
		return trainDao.save(train);
	}

	@Override
	public Train editTrain(Train train, Train exisTrain) {
        exisTrain.setName(train.getName());
		return trainDao.save(exisTrain);
	}

}
