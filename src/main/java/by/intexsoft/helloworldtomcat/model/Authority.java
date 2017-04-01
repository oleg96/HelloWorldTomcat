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

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }
}
