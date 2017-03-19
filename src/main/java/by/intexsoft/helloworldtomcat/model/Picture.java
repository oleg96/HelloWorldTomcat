package by.intexsoft.helloworldtomcat.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Picture entity class
 */
@Entity
@Table(name="picture")
@SuppressWarnings("serial")
public class Picture extends AbstractPersistable<Integer> {

    /**
     * Field stores picture author
     */
    @Column
    public String author;

    /**
     * Field stores picture name
     */
    @Column
    public String name;

    /**
     * Field stores picture description
     */
    @Column
    public String description;

    /**
     * Field stores picture owner
     */
    @Column
    public String owner;

    /**
     * Field stores picture tags
     */
    @Column
    public String tags;

    /**
     * Field stores path to image
     */
    @Column
    public String pathToImage;
}
