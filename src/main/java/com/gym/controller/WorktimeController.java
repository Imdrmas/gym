package com.gym.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gym.dto.SportsManDto;
import com.gym.dto.WorktimeDto;
import com.gym.manager.WorktimeManangerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class WorktimeController {

	@Autowired
	private WorktimeManangerService worktimeManangerService;
	
	  @PostMapping("/addSportsManForWork/{idSprtsMan}/{idWorktime}")
	  void addSportsManForWork(@PathVariable long idSprtsMan,  @PathVariable long idWorktime) {
		  worktimeManangerService.addSportsManForWork(idSprtsMan, idWorktime);
	  }
	
	  @PostMapping("/addWorktimeForGym/{idGym}")
	  WorktimeDto addWorktimeForGym(@RequestBody WorktimeDto worktime, @PathVariable long idGym) {
		  return worktimeManangerService.addWorktimeForGym(worktime, idGym);
	  }
	  @PutMapping("/editWorktime/{id}/{idGym}")
	  WorktimeDto editWorktime(@RequestBody WorktimeDto worktime, @PathVariable Long id, @PathVariable long idGym) {
		  return worktimeManangerService.editWorktime(worktime, id, idGym);
	  }
	  @DeleteMapping("/deleteWorktime/{id}")
	  void deleteWorktime(@PathVariable Long id) {
		  worktimeManangerService.deleteWorktime(id);
	  }
	  @GetMapping("/findWorktimeById/{id}")
	  WorktimeDto findWorktimeById(@PathVariable Long id) {
		  return worktimeManangerService.findWorktimeById(id);
	  }
	  @GetMapping("/findWorktimesForGym/{idGym}")
	  List<WorktimeDto> findWorktimesForGym(@PathVariable Long idGym) {
		  return worktimeManangerService.findWorktimesForGym(idGym);
	  }
	  
	  @GetMapping("/findSportsManForWorktime/{idWorktime}")
	  List<SportsManDto> findSportsManForWorktime(@PathVariable Long idWorktime) {
		  return worktimeManangerService.findSportsManForWorktime(idWorktime);
	  }
}
