package com.gym.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gym.dao.WorktimeDao;
import com.gym.model.Gym;
import com.gym.model.Worktime;
import com.gym.service.WorktimeService;

@Component
public class WorktimeServiceImpl implements WorktimeService {
	
	@Autowired
	private WorktimeDao worktimeDao;
	
	@Override
	public Worktime addWorktimeForGym(Worktime worktime, Gym gym) {
		gym.addWorktime(worktime);
		return worktimeDao.save(worktime);
	}

	@Override
	public Worktime editWorktime(Worktime worktime, Worktime existWorktime, Gym gym) {
       existWorktime.setDay(worktime.getDay());
       existWorktime.setTimetable(worktime.getTimetable());
       existWorktime.setEnd(worktime.getEnd());
       existWorktime.setStart(worktime.getStart());
		gym.addWorktime(existWorktime);
		return worktimeDao.save(existWorktime);
	}

}
