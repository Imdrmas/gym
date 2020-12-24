package com.gym.managerImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.dao.GymDao;
import com.gym.dao.SportDao;
import com.gym.dao.SportsManDao;
import com.gym.dto.SportDto;
import com.gym.manager.SportManagerService;
import com.gym.model.Gym;
import com.gym.model.OrikaBeanMapper;
import com.gym.model.Sport;
import com.gym.model.SportsMan;
import com.gym.service.SportService;

@Transactional
@Service
public class SportManagerServiceImpl implements SportManagerService {
	
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private SportDao sportDao;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private SportsManDao sportsManDao;
	
	@Autowired
	private GymDao gymDao;

	@Override
	public SportDto addSportForGym(SportDto sportDto, Long idGym) {
		Sport sport = orikaBeanMapper.map(sportDto, Sport.class);
		Gym gym = gymDao.findById(idGym).orElse(null);
		return orikaBeanMapper.convertDTO(sportService.addSport(sport, gym), SportDto.class);
	}

	@Override
	public SportDto editSport(SportDto sportDto, Long id) {
		Sport sport = orikaBeanMapper.map(sportDto, Sport.class);
		Sport existsSport = sportDao.findById(id).orElse(null);
		return orikaBeanMapper.convertDTO(sportService.editSport(sport, existsSport), SportDto.class);
	}

	@Override
	public void deleteSport(Long id) {
		Sport existsSport = sportDao.findById(id).orElse(null);
		sportDao.delete(existsSport);
	}

	@Override
	public SportDto findSportById(Long id) {
		return orikaBeanMapper.convertDTO(sportDao.findById(id).orElse(null), SportDto.class);
	}

	@Override
	public List<SportDto> findSportsForSportsMan(Long idSportsMan) {
		SportsMan sportsMan = sportsManDao.findById(idSportsMan).orElse(null);
		List<Sport> sports = sportsMan.getSports();
		return orikaBeanMapper.convertListDTO(sports, SportDto.class);
	}

	@Override
	public void addSportForSportsMan(long idSport, long idSportsMan) {
		SportsMan sportsMan = sportsManDao.findById(idSportsMan).orElse(null);
		Sport existsSport = sportDao.findById(idSport).orElse(null);
		sportsMan.addSport(existsSport);
	}

	@Override
	public List<SportDto> findSportsForGym(Long idGym) {
		Gym gym = gymDao.findById(idGym).orElse(null);
		List<Sport> sports = gym.getSports();
		return orikaBeanMapper.convertListDTO(sports, SportDto.class);
	}

}
