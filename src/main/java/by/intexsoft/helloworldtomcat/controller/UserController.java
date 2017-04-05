package by.intexsoft.helloworldtomcat.controller;

import java.io.IOException;
import java.util.List;

import by.intexsoft.helloworldtomcat.model.Login;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.service.UserService;

/**
 * User controller for application
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * Register method
	 * Parse income {@link Login} object
	 * Add {@link by.intexsoft.helloworldtomcat.model.User} do database if not exists
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody String userPass) throws IOException {
		LOGGER.info("Start registration");
		ObjectMapper mapper = new ObjectMapper();
		Login login = mapper.readValue(userPass, Login.class);
		User newUser = new User();
		newUser.name = login.username;
		newUser.password = login.password;
		if (userService.findByName(newUser.name) == null) {
			User addedUser = userService.add(newUser);
			if (addedUser != null) {
				LOGGER.info("Registration successful");
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		LOGGER.error("Registration failed");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Method get all users in JSON format
	 * @return List<{@link User}>
	 */
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		LOGGER.info("Start getAllUsers method");
		try {
			List<User> users = userService.findAll();
			return users;
		} catch (NullPointerException e) {
			LOGGER.error("Exception in getAllUsers method: " + e.getLocalizedMessage());
			return null;
		}
	}
	
	/**
	 * Method get user in JSON format
	 * @param name
	 * @return {@link User}
	 */
	@RequestMapping("/users/{name}")
	public User getUser(@PathVariable("name") String name) {
		LOGGER.info("Start getUser method");
		try {
			User user = userService.findByName(name);
			return user;
		} catch (NullPointerException e) {
			LOGGER.error("Exception in getUser method: " + e.getLocalizedMessage());
			return null;
		}
	}
}
