package com.prverse.prverse.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prverse.prverse.entity.User;
@Service
public interface UserService {
	public List<User> getAllUsers();
	public Optional<User> getUserByID(Long id);
	public void deleteUserByID(Long id);
	public void createNewUser(User user);
	public void updateUser(long id, User user);
}
