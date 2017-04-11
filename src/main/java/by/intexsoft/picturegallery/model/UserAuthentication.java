package by.intexsoft.picturegallery.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Model representation for security
 */
public class UserAuthentication implements Authentication {

    private final User user;
    private boolean authenticated = true;

    /**
     * Constructor for {@link UserAuthentication} class
     * @param user
     */
    public UserAuthentication(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.authorities;
    }

    @Override
    public Object getCredentials() {
        return user.password;
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user.name;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return user.name;
    }
}
