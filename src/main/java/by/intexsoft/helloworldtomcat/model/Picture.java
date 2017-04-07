package by.intexsoft.helloworldtomcat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Picture entity class
 */
@Entity
@Table(name="picture")
public class Picture extends Base {

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
     * Field stores image base64 data
     */
    @Column
    public String image;
}
