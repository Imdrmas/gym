package com.gym.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gym.dao.SportsManDao;
import com.gym.model.SportsMan;
import com.gym.service.SportsManService;

@Component
public class SportsManImpl implements SportsManService {
	
	@Autowired
	private SportsManDao sportsManDao;

	@Override
	public SportsMan addSportsMan(SportsMan sportsMan) {
		return sportsManDao.save(sportsMan);
	}

	@Override
	public SportsMan editSportsMan(SportsMan sportsMan, SportsMan existSportsMan) {
		existSportsMan.setFirstName(sportsMan.getFirstName());
		existSportsMan.setLastName(sportsMan.getLastName());
		existSportsMan.setAge(sportsMan.getAge());
		existSportsMan.setSex(sportsMan.getSex());
		existSportsMan.setAvatar(sportsMan.getAvatar());
		return sportsManDao.save(existSportsMan);
	}

}
