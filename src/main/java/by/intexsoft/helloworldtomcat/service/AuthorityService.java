package by.intexsoft.helloworldtomcat.service;

import by.intexsoft.helloworldtomcat.model.Authority;

import java.util.List;

/**
 * Interface for {@link Authority} service
 */
public interface AuthorityService {

    /**
     * Method adds authority to database
     * @param authority
     * @return {@link Authority}
     */
    Authority add(Authority authority);

    /**
     * Method removes authority from database
     * @param id
     */
    void delete(int id);

    /**
     * Method search authority in database by id
     * @param id
     * @return {@link Authority}
     */
    Authority findById(int id);

    /**
     * Method search user in database by name
     * @param name
     * @return {@link Authority}
     */
    Authority findByName(String name);

    /**
     * Method edit user in database
     * @param user
     * @return {@link Authority}
     */
    Authority edit(Authority user);

    /**
     * Method get all users from database
     * @return List<{@link User}>
     */
    List<Authority> findAll();
}
