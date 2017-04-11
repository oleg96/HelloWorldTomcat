package by.intexsoft.helloworldtomcat.security.service;

import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.model.UserAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for {@link Authentication} service
 */
public interface TokenAuthenticationService {

    /**
     * Method for authenticate {@link User}
     * @param request
     * @return {@link UserAuthentication}
     */
    Authentication authenticate(HttpServletRequest request);
}
