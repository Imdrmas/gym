package com.gym.managerImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.dao.SportsManDao;
import com.gym.dto.SportsManDto;
import com.gym.manager.SportsManManagerService;
import com.gym.model.OrikaBeanMapper;
import com.gym.model.SportsMan;
import com.gym.service.SportsManService;

@Transactional
@Service
public class SportsManManagerServiceImpl implements SportsManManagerService {
	
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private SportsManDao sportsManDao;
	
	@Autowired
	private SportsManService sportsManService;

	@Override
	public SportsManDto addSportsMan(SportsManDto sportsManDto) {
		SportsMan sportsMan = orikaBeanMapper.map(sportsManDto, SportsMan.class);
		return orikaBeanMapper.convertDTO(sportsManService.addSportsMan(sportsMan), SportsManDto.class);
	}

	@Override
	public SportsManDto editSportsMan(SportsManDto sportsManDto, Long id) {
		SportsMan sportsMan = orikaBeanMapper.map(sportsManDto, SportsMan.class);
		SportsMan existSportsMan = sportsManDao.findById(id).orElse(null);
		return orikaBeanMapper.convertDTO(sportsManService.editSportsMan(existSportsMan, sportsMan), SportsManDto.class);
	}

	@Override
	public void deleteSportsMan(Long id) {
		SportsMan existSportsMan = sportsManDao.findById(id).orElse(null);
		sportsManDao.delete(existSportsMan);
	}

	@Override
	public SportsManDto findSportsManById(Long id) {
		return orikaBeanMapper.convertDTO(sportsManDao.findById(id).orElse(null), SportsManDto.class);
	}

	@Override
	public List<SportsManDto> findAllSportsMans() {
		List<SportsMan> sportsMans = sportsManDao.findAll();
		return orikaBeanMapper.convertListDTO(sportsMans, SportsManDto.class);
	}

}
