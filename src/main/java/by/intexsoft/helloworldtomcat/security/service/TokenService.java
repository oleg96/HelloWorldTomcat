package by.intexsoft.helloworldtomcat.security.service;

public interface TokenService {

    String generateToken(String username, String password);
}
