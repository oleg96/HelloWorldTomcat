package by.intexsoft.picturegallery.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base entity for all entities
 */
@MappedSuperclass
public abstract class Base {

    /**
     * Field stores id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
}
