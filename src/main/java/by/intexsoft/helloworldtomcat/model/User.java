package by.intexsoft.helloworldtomcat.model;

import javax.persistence.*;
import java.util.List;

/**
 * User entity class
 */
@Entity
@Table(name = "users")
public class User extends Base {

    /**
     * Field stores user name
     */
    @Column
    public String name;

    /**
     * Field stores user password
     */
    @Column
    public String password;

    /**
     * Field stores user {@link Authority}s
     */
    @ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    public List<Authority> authorities;

    /**
     * Method set authorities for user
     * @param authorities
     */
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
