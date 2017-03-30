package by.intexsoft.helloworldtomcat.controller;

import by.intexsoft.helloworldtomcat.model.Login;
import by.intexsoft.helloworldtomcat.model.Token;
import by.intexsoft.helloworldtomcat.security.service.TokenService;
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
 * Handle requests for authentication operations
 * Works with {@link TokenService}
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private TokenService tokenService;

    /**
     * Login method
     * Parse income {@link Login} object
     * Find {@link by.intexsoft.helloworldtomcat.model.User} in database by username
     * Generate token from {@link TokenService}
     * @return {@link String} token
     */
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody String userPass) throws IOException {
        LOGGER.info("Start authentication");
        ObjectMapper mapper = new ObjectMapper();
        Login login = mapper.readValue(userPass, Login.class);
        String tokenString = tokenService.generateToken(login.username, login.password);
        Token token = new Token();
        token.token = tokenString;
        String tokenJSON = mapper.writeValueAsString(token);
        if (tokenString != null) {
            LOGGER.info("Authentication successful! Returning token");
            return new ResponseEntity<>(tokenJSON, HttpStatus.OK);
        }
        LOGGER.error("Authentication failed");
        return new ResponseEntity<>("Authentication failed", HttpStatus.BAD_REQUEST);
    }
}