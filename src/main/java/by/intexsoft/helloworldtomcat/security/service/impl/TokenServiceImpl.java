package by.intexsoft.helloworldtomcat.security.service.impl;

import by.intexsoft.helloworldtomcat.model.User;
import by.intexsoft.helloworldtomcat.security.service.TokenService;
import by.intexsoft.helloworldtomcat.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
        if (password.equals(user.getPassword())) {
            tokenData.put("clientType", "user");
            tokenData.put("userID", user.getId());
            tokenData.put("username", user.getUsername());
            tokenData.put("token_create_date", LocalDateTime.now());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 60);
            tokenData.put("token_expiration_date", calendar.getTime());
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);
            return jwtBuilder.signWith(SignatureAlgorithm.HS512, tokenKey).compact();
        } else {
            System.out.println("ERROR");
            return null;
        }
    }
}
