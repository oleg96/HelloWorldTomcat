package by.intexsoft.helloworldtomcat.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
