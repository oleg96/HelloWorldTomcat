package by.intexsoft.helloworldtomcat.service.impl;

import java.util.*;

import by.intexsoft.helloworldtomcat.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.repository.UserRepository;
import by.intexsoft.helloworldtomcat.service.UserService;

/**
 * Implementation of {@link UserService} interface
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User add(User user) {
		Authority authority = new Authority();
		authority.setName("ROLE_USER");
		user.setAuthorities(Arrays.asList(authority));
		User savedUser = userRepository.saveAndFlush(user);
		return savedUser;
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
