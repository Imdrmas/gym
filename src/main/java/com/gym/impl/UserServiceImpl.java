package com.gym.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gym.dao.UserDao;
import com.gym.model.User;
import com.gym.service.UserService;

@Transactional
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return userDao.findById(id).orElse(null);
	}

	@Override
	public User editUser(User user, Long id) {
       User exsitUser = userDao.findById(id).orElse(null);
       exsitUser.setUsername(user.getUsername());
       exsitUser.setPassword(user.getPassword());
       exsitUser.setAdmin(user.isAdmin());
		return userDao.save(exsitUser);
	}

	@Override
	public Optional<User> findUserByUsername(String username) {
		Optional<User> users = userDao.findByUsername(username);
		return users;
	}

	@Override
	public void deleteUser(long id) {
		User exsitUser = userDao.findById(id).orElse(null);
		userDao.delete(exsitUser);
	}

}
