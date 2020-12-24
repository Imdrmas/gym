package com.gym.service;

import com.gym.model.Arbitrate;
import com.gym.model.Gym;

public interface ArbitrateService {
	
	Arbitrate addArbitrateForGym(Arbitrate arbitrate, Gym gym);
	
	Arbitrate editArbitrate(Arbitrate arbitrate, Arbitrate existsArbitrate);
	
}
