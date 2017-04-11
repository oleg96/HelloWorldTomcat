package by.intexsoft.helloworldtomcat.model;


/**
 * Token entity
 */
public class Token {

    /**
     * Field stores token data string
     */
    public String token;

    /**
     * Field stores {@link User} entity
     */
    public User user;


    /**
     * Constructor for {@link Token} class
     * @param token
     * @param user
     */
    public Token(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
