package com.gym.service;

import com.gym.model.Gym;
import com.gym.model.Worktime;

public interface WorktimeService {
	
  Worktime addWorktimeForGym(Worktime worktime, Gym gym);
  
  Worktime editWorktime(Worktime worktime, Worktime existWorktime, Gym gym);
  
}
