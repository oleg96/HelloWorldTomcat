package by.intexsoft.picturegallery.service.impl;

import by.intexsoft.picturegallery.model.User;
import by.intexsoft.picturegallery.repository.AuthorityRepository;
import by.intexsoft.picturegallery.repository.UserRepository;
import by.intexsoft.picturegallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link UserService} interface
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository roleRepository;

	@Override
	public User add(User user) {
		user.setAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER")));
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}
	
	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	@Override
	public User edit(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
