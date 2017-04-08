package by.intexsoft.helloworldtomcat.controller;

import by.intexsoft.helloworldtomcat.model.Token;
import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.security.service.TokenService;
import by.intexsoft.helloworldtomcat.service.UserService;
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

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Handle requests for authentication operations
 * Works with {@link TokenService}
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    /**
     * Login method
     * Find {@link by.intexsoft.helloworldtomcat.model.User} in database by username
     * Generate token from {@link TokenService}
     *
     * @return {@link String} token
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody User requestUser) throws IOException {
        LOGGER.info("Start authentication");
        if (isNotEmpty(requestUser.name) && isNotEmpty(requestUser.password)) {
            User user = userService.findByName(requestUser.name);
            String token = tokenService.generateToken(user.name, requestUser.password);
            if (token != null) {
                LOGGER.info("Authentication successful! Returning token");
                user.password = EMPTY;
                return new ResponseEntity<>(new Token(token, user), HttpStatus.OK);
            }
        }
        LOGGER.error("Authentication failed");
        return new ResponseEntity<>("Authentication failed", HttpStatus.BAD_REQUEST);
    }
}