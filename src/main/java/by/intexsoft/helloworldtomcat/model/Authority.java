package by.intexsoft.helloworldtomcat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Authority entity class
 */
@Entity
@Table(name = "authority")
public class Authority extends Base implements GrantedAuthority {

    /**
     * Field stores authority name
     */
    @Column
    public String name;

    /**
     * Implemented method to get Authority name
     * @return name
     */
    @Override
    public String getAuthority() {
        return name;
    }
}
