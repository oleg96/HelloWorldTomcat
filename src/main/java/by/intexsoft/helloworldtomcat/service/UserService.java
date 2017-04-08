package by.intexsoft.helloworldtomcat.service;

import java.util.List;
import by.intexsoft.helloworldtomcat.model.User;

/**
 * Interface for {@link User} service
 */
public interface UserService {

	/**
	 * Method adds user to database
	 * @param user
	 * @return {@link User}
	 */
	User add(User user);
	/**
	 * Method removes user from database
	 * @param id
	 */
	void delete(int id);
	/**
	 * Method search user in database by id
	 * @param id
	 * @return {@link User}
	 */
	User findById(int id);
	/**
	 * Method search user in database by name
	 * @param name
	 * @return {@link User}
	 */
	User findByName(String name);
	/**
	 * Method edit user in database
	 * @param user
	 * @return {@link User}
	 */
	User edit(User user);
	/**
	 * Method get all users from database
	 * @return List<{@link User}>
	 */
	List<User> findAll();
}
