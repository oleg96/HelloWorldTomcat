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
 * Handle requests for register operations
 */
@RestController
public class RegisterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private RegisterService registerService;

    /**
     * Login method
     * Parse income {@link Login} object
     * Find {@link by.intexsoft.helloworldtomcat.model.User} in database by username
     * Generate token from {@link TokenService}
     *
     * @return {@link String} token
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody String userPass) throws IOException {
        LOGGER.info("Start registration");
        ObjectMapper mapper = new ObjectMapper();
        Login login = mapper.readValue(userPass, Login.class);
        String tokenString = tokenService.generateToken(login.username, login.password);
        Token token = new Token();
        token.token = tokenString;
        String tokenJSON = mapper.writeValueAsString(token);
        if (token != null) {
            //TokenDTO response = new TokenDTO();
            //response.token = token;
            LOGGER.info("Registration successful");
            return new ResponseEntity<>(tokenJSON, HttpStatus.OK);
        }
        LOGGER.error("Registration failed");
        return new ResponseEntity<>("Registration failed", HttpStatus.BAD_REQUEST);
    }
}