package by.intexsoft.helloworldtomcat.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * User entity class
 */
@Entity
@Table(name="users")
@SuppressWarnings("serial")
public class User extends AbstractPersistable<Integer> implements UserDetails {
	
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

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authorities;

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuths = new ArrayList<>();
//        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		return this.authorities;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
}
