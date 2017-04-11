package by.intexsoft.picturegallery.security.service;

import by.intexsoft.picturegallery.model.User;
import by.intexsoft.picturegallery.model.UserAuthentication;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

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
