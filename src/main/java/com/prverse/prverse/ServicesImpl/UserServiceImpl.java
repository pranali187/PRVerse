package com.prverse.prverse.ServicesImpl;

import com.prverse.prverse.Service.UserService;
import com.prverse.prverse.entity.User;
import com.prverse.prverse.repository.UserRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createNewUser(User user) {

 	        // Encode password before saving
 	        user.setPassword(passwordEncoder.encode(user.getPassword()));

 	        return userRepo.save(user);

    }

	@Override
	public void updateUser(long id, User user) {
		User u = userRepo.findByUserId(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setPhone(user.getPhone());
		userRepo.save(u);
	}

	  
}
