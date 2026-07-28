package com.prverse.prverse.ServicesImpl;

import com.prverse.prverse.Service.UserService;
import com.prverse.prverse.entity.User;
import com.prverse.prverse.repository.UserRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserByID(Long id) {
		return userRepo.findByUserId(id);
	}

	@Override
	public void deleteUserByID(Long id) {
		userRepo.deleteById(id);
	}


}
