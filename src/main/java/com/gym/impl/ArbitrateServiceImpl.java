package com.gym.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gym.dao.ArbitrateDao;
import com.gym.model.Arbitrate;
import com.gym.model.Gym;
import com.gym.service.ArbitrateService;

@Component
public class ArbitrateServiceImpl implements ArbitrateService {
	
	@Autowired
	private ArbitrateDao arbitrateDao;

	@Override
	public Arbitrate editArbitrate(Arbitrate arbitrate, Arbitrate existArbitrate) {
		existArbitrate.setName(arbitrate.getName());
		return arbitrateDao.save(existArbitrate);
	}

	@Override
	public Arbitrate addArbitrateForGym(Arbitrate arbitrate, Gym gym) {
		gym.addArbitrate(arbitrate);
		return arbitrateDao.save(arbitrate);
	}


}
