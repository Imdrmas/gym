package com.gym.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gym.dao.SportDao;
import com.gym.model.Gym;
import com.gym.model.Sport;
import com.gym.service.SportService;

@Component
public class SportServiceImpl implements SportService {
	
	@Autowired
	private SportDao sportDao;

	@Override
	public Sport addSport(Sport sport, Gym gym) {
        gym.addSportForGym(sport);
		return sportDao.save(sport);
	}

	@Override
	public Sport editSport(Sport sport, Sport existSport) {
		existSport.setName(sport.getName());
		existSport.setDescription(sport.getDescription());
		existSport.setPhoto(sport.getPhoto());
		return sportDao.save(existSport);
	}

}
