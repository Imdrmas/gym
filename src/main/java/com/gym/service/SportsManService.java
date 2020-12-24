package com.gym.service;

import com.gym.model.SportsMan;

public interface SportsManService {

	SportsMan addSportsMan(SportsMan sportsMan);
	
	SportsMan editSportsMan(SportsMan sportsMan, SportsMan existSportsMan);

}
