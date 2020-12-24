package com.gym.managerImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.dao.ArbitrateDao;
import com.gym.dao.GymDao;
import com.gym.dao.SportDao;
import com.gym.dto.ArbitrateDto;
import com.gym.manager.ArbitrateManagerService;
import com.gym.model.Arbitrate;
import com.gym.model.Gym;
import com.gym.model.OrikaBeanMapper;
import com.gym.model.Sport;
import com.gym.service.ArbitrateService;

@Transactional
@Service
public class ArbitrateManagerServiceImpl implements ArbitrateManagerService {
	
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private ArbitrateService arbitrateService;
	
	@Autowired
	private SportDao sportDao;
	
	@Autowired
	private ArbitrateDao arbitrateDao;
	
	@Autowired
	private GymDao gymDao;

	@Override
	public ArbitrateDto addArbitrateForGym(ArbitrateDto arbitrateDto, long idGym) {
		Gym gym = gymDao.findById(idGym).orElse(null);
		Arbitrate arbitrate = orikaBeanMapper.map(arbitrateDto, Arbitrate.class);
		return orikaBeanMapper.convertDTO(arbitrateService.addArbitrateForGym(arbitrate, gym), ArbitrateDto.class);
	}

	@Override
	public ArbitrateDto editArbitrate(ArbitrateDto arbitrateDto, long id) {
		Arbitrate existsArbitrate = arbitrateDao.findById(id).orElse(null);
		Arbitrate arbitrate = orikaBeanMapper.map(arbitrateDto, Arbitrate.class);
		return orikaBeanMapper.convertDTO(
				arbitrateService.editArbitrate(arbitrate, existsArbitrate), ArbitrateDto.class);
	}

	@Override
	public void deleteArbitrate(long id) {
		Arbitrate existsArbitrate = arbitrateDao.findById(id).orElse(null);
		arbitrateDao.delete(existsArbitrate);
	}

	@Override
	public ArbitrateDto findArbitrateById(long id) {
		return orikaBeanMapper.convertDTO(arbitrateDao.findById(id).orElse(null), ArbitrateDto.class);
	}

	@Override
	public List<ArbitrateDto> findArbitratesForSport(long idSport) {
		Sport sport = sportDao.findById(idSport).orElse(null);
		List<Arbitrate> arbitrates = sport.getArbitrates();
		return orikaBeanMapper.convertListDTO(arbitrates, ArbitrateDto.class);
	}

	@Override
	public void addArbitrateForSport(long idArbitrate, long idSport) {
		Sport sport = sportDao.findById(idSport).orElse(null);
		Arbitrate arbitrate = arbitrateDao.findById(idArbitrate).orElse(null);
		sport.addArbitrate(arbitrate);
	}

	@Override
	public List<ArbitrateDto> findArbitratesForGym(long idGym) {
		Gym gym = gymDao.findById(idGym).orElse(null);
		List<Arbitrate> arbitrates = gym.getArbitrates();
		return orikaBeanMapper.convertListDTO(arbitrates, ArbitrateDto.class);
	}

	@Override
	public List<ArbitrateDto> findAllArbitrates() {
		List<Arbitrate> arbitrates = arbitrateDao.findAll();
		return orikaBeanMapper.convertListDTO(arbitrates, ArbitrateDto.class);
	}

}
