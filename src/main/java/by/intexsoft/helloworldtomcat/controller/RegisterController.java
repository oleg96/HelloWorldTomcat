package by.intexsoft.helloworldtomcat.controller;

import by.intexsoft.helloworldtomcat.model.Login;
import by.intexsoft.helloworldtomcat.model.Token;
import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.security.service.TokenService;
import by.intexsoft.helloworldtomcat.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Handle requests for register operations
 */
@RestController
public class RegisterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    /**
     * Login method
     * Parse income {@link Login} object
     * Find {@link by.intexsoft.helloworldtomcat.model.User} in database by username
     * Generate token from {@link TokenService}
     *
     * @return {@link String} token
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
}