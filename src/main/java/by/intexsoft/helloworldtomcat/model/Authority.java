package by.intexsoft.helloworldtomcat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="authority")
public class Authority extends AbstractPersistable<Integer> implements GrantedAuthority {

    @Column(name="name")
    String name;

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
