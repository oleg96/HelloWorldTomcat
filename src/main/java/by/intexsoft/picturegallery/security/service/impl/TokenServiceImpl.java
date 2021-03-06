package by.intexsoft.picturegallery.security.service.impl;

import by.intexsoft.picturegallery.model.User;
import by.intexsoft.picturegallery.security.service.TokenService;
import by.intexsoft.picturegallery.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link TokenService} interface
 */
@Service
public class TokenServiceImpl implements TokenService {

    private String tokenKey = "7788secretKey";

    @Autowired
    private UserService userService;

    @Override
    public String generateToken(String username, String password) {
        if (username == null || password == null)
            return null;
        User user = userService.findByName(username);
        Map<String, Object> tokenData = new HashMap<>();
        if (user != null && password.equals(user.password)) {
            tokenData.put("clientType", "user");
            tokenData.put("userID", user.id);
            tokenData.put("username", user.name);
            tokenData.put("token_create_date", LocalDateTime.now());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 60);
            tokenData.put("token_expiration_date", calendar.getTime());
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);
            return jwtBuilder.signWith(SignatureAlgorithm.HS512, tokenKey).compact();
        }
        System.out.println("Error during token generation");
        return null;
    }
}
