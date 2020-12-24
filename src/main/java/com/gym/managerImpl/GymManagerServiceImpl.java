package com.gym.managerImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.dao.GymDao;
import com.gym.dto.GymDto;
import com.gym.manager.GymManagerService;
import com.gym.model.Gym;
import com.gym.model.OrikaBeanMapper;
import com.gym.service.GymService;

@Transactional
@Service
public class GymManagerServiceImpl implements GymManagerService {
 
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private GymService gymService;
	
	@Autowired
	private GymDao gymDao;

	@Override
	public GymDto addGym(GymDto gymDto) {
		Gym gym = orikaBeanMapper.map(gymDto, Gym.class);
		return orikaBeanMapper.convertDTO(gymService.addGym(gym), GymDto.class);
	}

	@Override
	public GymDto editGym(GymDto gymDto, Long id) {
		Gym gym = orikaBeanMapper.map(gymDto, Gym.class);
		Gym existsGym = gymDao.findById(id).orElse(null);
		return orikaBeanMapper.convertDTO(gymService.editGym(gym, existsGym), GymDto.class);
	}

	@Override
	public void deleteGym(Long id) {
		Gym existsGym = gymDao.findById(id).orElse(null);
		gymDao.delete(existsGym);
	}

	@Override
	public GymDto findGymById(Long id) {
		return orikaBeanMapper.convertDTO(gymDao.findById(id).orElse(null), GymDto.class);
	}

	@Override
	public List<GymDto> findAllGyms() {
		List<Gym> gyms = gymDao.findAll();
		return orikaBeanMapper.convertListDTO(gyms, GymDto.class);
	}
}
