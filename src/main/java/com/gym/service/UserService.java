package com.gym.service;

import java.util.Optional;
import com.gym.model.User;

public interface UserService {
	
  User addUser(User user);
  
  User editUser(User user, Long id);
  
  User findUserById(Long id);
  
  Optional<User> findUserByUsername(String username);
  
  void deleteUser(long id);
}
