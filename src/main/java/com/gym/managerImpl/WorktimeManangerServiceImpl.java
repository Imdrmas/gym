package com.gym.managerImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.dao.GymDao;
import com.gym.dao.SportsManDao;
import com.gym.dao.WorktimeDao;
import com.gym.dto.SportsManDto;
import com.gym.dto.WorktimeDto;
import com.gym.manager.WorktimeManangerService;
import com.gym.model.Gym;
import com.gym.model.OrikaBeanMapper;
import com.gym.model.SportsMan;
import com.gym.model.Worktime;
import com.gym.service.WorktimeService;

@Transactional
@Service
public class WorktimeManangerServiceImpl implements WorktimeManangerService {

	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private WorktimeDao worktimeDao;
	
	@Autowired 
	private WorktimeService worktimeService;
	
	@Autowired
	private GymDao gymDao;
	
	@Autowired
	private SportsManDao sportsManDao;

	@Override
	public void addSportsManForWork(long idSprtsMan, long idWorktime) {
		SportsMan sportsMan = sportsManDao.findById(idSprtsMan).orElse(null);
		Worktime worktime = worktimeDao.findById(idWorktime).orElse(null);
		worktime.addSportsManForWork(sportsMan);
	}

	@Override
	public WorktimeDto addWorktimeForGym(WorktimeDto worktimeDto, long idGym) {
		Gym gym = gymDao.findById(idGym).orElse(null);
		Worktime worktime = orikaBeanMapper.map(worktimeDto, Worktime.class);
		return orikaBeanMapper.convertDTO(worktimeService.addWorktimeForGym(worktime, gym), WorktimeDto.class);
	}

	@Override
	public WorktimeDto editWorktime(WorktimeDto worktimeDto, Long id, long idGym) {
		Worktime worktime = orikaBeanMapper.map(worktimeDto, Worktime.class);
		Worktime existsWorktime = worktimeDao.findById(id).orElse(null);
		Gym gym = gymDao.findById(idGym).orElse(null);
		return orikaBeanMapper.convertDTO(worktimeService.editWorktime(worktime, existsWorktime, gym), WorktimeDto.class);
	}

	@Override
	public void deleteWorktime(Long id) {
		Worktime existsWorktime = worktimeDao.findById(id).orElse(null);
		worktimeDao.delete(existsWorktime);
	}

	@Override
	public WorktimeDto findWorktimeById(Long id) {
		return orikaBeanMapper.convertDTO(worktimeDao.findById(id).orElse(null), WorktimeDto.class);
	}

	@Override
	public List<WorktimeDto> findWorktimesForGym(Long idGym) {
		Gym gym = gymDao.findById(idGym).orElse(null);
		List<Worktime> worktimes = gym.getWorktimes();
		return orikaBeanMapper.convertListDTO(worktimes, WorktimeDto.class);
	}

	@Override
	public List<SportsManDto> findSportsManForWorktime(Long idWorktime) {
		Worktime worktime = worktimeDao.findById(idWorktime).orElse(null);
		List<SportsMan> sportsMans = worktime.getSportsMans();
		return orikaBeanMapper.convertListDTO(sportsMans, SportsManDto.class);
	}
}
