package com.gym.controller;

import java.util.Optional;

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

import com.gym.model.User;
import com.gym.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	 @PostMapping("/addUser")
	 User addUser(@RequestBody User user) {
		  return userService.addUser(user);
	  }
	 
	 @PutMapping("/editUser/{id}")
	 User editUser(@RequestBody User user, @PathVariable long id) {
		return userService.editUser(user, id);
	  }
	 
	  @GetMapping("/findUserById")
	  User findUserById(@PathVariable long id) {
		  return userService.findUserById(id);
	  }
	  
	  @GetMapping("/findUserByUsername/{username}")
	  Optional<User> findUserByUsername(@PathVariable String username) {
		  return userService.findUserByUsername(username);
	  }
	  
	  @DeleteMapping("/deleteUser/{id}")
	  void deleteUser(@PathVariable long id) {
		  userService.deleteUser(id);
	  }
	  
}
