package by.intexsoft.helloworldtomcat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import by.intexsoft.helloworldtomcat.model.User;

/**
 * Interface for {@link JpaRepository}
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Custom method to find user by name
	 * @param name
	 * @return {@link User}
	 */
	User findByName(@Param("name") String name);
}
