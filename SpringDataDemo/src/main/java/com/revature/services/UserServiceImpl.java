package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(Long id) {
		return userRepo.getOne(id);
	}

	@Override
	public User addUser(User newUser) {
		
		for( User user : findAllUsers()) {
			if(user.getUsername().equals(newUser.getUsername())) {
				return null;
			}
			if(user.getEmail().equals(newUser.getEmail())) {
				return null;
			}
			
		}
		return userRepo.save(newUser);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

//	@Override
//	public User loginUser(User u) {
//		return userRepo.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
//	}

	@Override
	public User deleteUser(User user) {
		userRepo.delete(user);
		return user;
	}

}
