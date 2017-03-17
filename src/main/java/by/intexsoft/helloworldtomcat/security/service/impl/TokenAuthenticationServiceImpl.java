package by.intexsoft.helloworldtomcat.security.service.impl;

import by.intexsoft.helloworldtomcat.controller.SimpleController;
import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.model.UserAuthentication;
import by.intexsoft.helloworldtomcat.security.service.TokenAuthenticationService;
import by.intexsoft.helloworldtomcat.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private String secretKey = "7788secretKey";

    private final static String AUTH_HEADER_NAME = "x-auth-token";

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationServiceImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        String token = request.getHeader(AUTH_HEADER_NAME);
        LOGGER.info("Request token: "+token);
        if (token != null) {
            final Jws<Claims> tokenData = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            User user = getUserFromToken(tokenData);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }

    private User getUserFromToken(Jws<Claims> tokenData) {
        try {
            return userService.findByName(tokenData.getBody().get("username").toString());
        } catch (UsernameNotFoundException e) {
            return null;
        }
    }
}
