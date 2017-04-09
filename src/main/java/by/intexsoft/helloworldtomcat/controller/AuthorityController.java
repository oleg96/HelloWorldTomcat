package by.intexsoft.helloworldtomcat.controller;

import by.intexsoft.helloworldtomcat.model.Authority;
import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User controller for application
 */
@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityController.class);

    /**
     * Method get all authorities in JSON format
     *
     * @return List<{@link Authority}>
     */
    @RequestMapping("/authorities")
    public List<Authority> getAllAuthorities() {
        LOGGER.info("Start getAllAuthorities method");
        try {
            List<Authority> authorities = authorityService.findAll();
            return authorities;
        } catch (NullPointerException e) {
            LOGGER.error("Exception in getAllAuthorities method: " + e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Method get authority in JSON format
     *
     * @param id
     * @return {@link User}
     */
    @RequestMapping("/authorities/:{id}")
    public Authority getAuthority(@PathVariable("id") int id) {
        LOGGER.info("Start getAuthority method");
        try {
            Authority authority = authorityService.findById(id);
            return authority;
        } catch (NullPointerException e) {
            LOGGER.error("Exception in getAuthority method: " + e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Method get authority in JSON format
     *
     * @param name
     * @return {@link User}
     */
    @RequestMapping("/users/{name}")
    public Authority getAuthority(@PathVariable("name") String name) {
        LOGGER.info("Start getAuthority method");
        try {
            Authority authority = authorityService.findByName(name);
            return authority;
        } catch (NullPointerException e) {
            LOGGER.error("Exception in getAuthority method: " + e.getLocalizedMessage());
            return null;
        }
    }
}
