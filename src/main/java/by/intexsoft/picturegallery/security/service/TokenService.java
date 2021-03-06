package by.intexsoft.picturegallery.security.service;

/**
 * Interface for token generation service
 */
public interface TokenService {

    /**
     * Method generate token for user
     * @param username
     * @param password
     * @return token
     */
    String generateToken(String username, String password);
}
