package by.intexsoft.helloworldtomcat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * User entity class
 */
@Entity
@Table(name="users")
@SuppressWarnings("serial")
public class User extends AbstractPersistable<Integer> {
	
	/**
	 * Field stores user name
	 */
	@Column
	public String name;
	
}
