package by.intexsoft.helloworldtomcat.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.service.UserService;

/**
 * Main controller for application
 */
@RestController
@RequestMapping("/service")
public class SimpleController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);
	
	/**
	 * Method get simple hello world message
	 * @return helloMessage
	 */
	@RequestMapping(value="/hello", produces="text/html;charset=UTF-8")
	public String getHelloMessage() {
		LOGGER.info("Start hello method");
		String helloMessage = "Привет мир! Меня написал Олег";
		return helloMessage;
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
