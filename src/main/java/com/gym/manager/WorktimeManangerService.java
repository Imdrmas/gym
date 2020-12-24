package com.gym.manager;

import java.util.List;
import com.gym.dto.SportsManDto;
import com.gym.dto.WorktimeDto;

public interface WorktimeManangerService {
	
 void addSportsManForWork(long idSprtsMan, long idWorktime);
	
  WorktimeDto addWorktimeForGym(WorktimeDto worktimeDto, long idGym);
  
  WorktimeDto editWorktime(WorktimeDto worktimeDto, Long id, long idGym);
  
  void deleteWorktime(Long id);
  
  WorktimeDto findWorktimeById(Long id);
  
  List<WorktimeDto> findWorktimesForGym(Long idGym);
  
  List<SportsManDto> findSportsManForWorktime(Long idWorktime);
}
