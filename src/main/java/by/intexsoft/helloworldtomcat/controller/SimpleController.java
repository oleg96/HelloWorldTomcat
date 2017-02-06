package by.intexsoft.helloworldtomcat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import by.intexsoft.helloworldtomcat.service.UserService;
import by.intexsoft.helloworldtomcat.model.User;

/**
 * Main controller for application
 */
@RestController
@RequestMapping("/service")
public class SimpleController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Method get simple hello world message
	 * @return helloMessage
	 */
	@RequestMapping(value="/hello", produces="text/html;charset=UTF-8")
	public String getHelloMessage() {
		String helloMessage = "Привет мир! Меня написал Олег";
		return helloMessage;
	}
	
	/**
	 * Method get all users in JSON format
	 * @return List<{@link User}>
	 */
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		List<User> users = userService.getAll();
		return users;
	}
	
	/**
	 * Method get user in JSON format
	 * @param name
	 * @return {@link User}
	 */
	@RequestMapping("/users/{name}")
	public User getUser(@PathVariable String name) {
		User user = userService.getByName(name);
		return user;
	}
}
