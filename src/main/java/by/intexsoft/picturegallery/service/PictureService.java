package by.intexsoft.picturegallery.service;

import by.intexsoft.picturegallery.model.Picture;

import java.util.List;

/**
 * Interface for {@link Picture} service
 */
public interface PictureService {

    /**
     * Method adds picture to database
     * @param picture
     * @return {@link Picture}
     */
    Picture add(Picture picture);

    /**
     * Method removes picture from database
     * @param id
     */
    void delete(int id);

    /**
     * Method search picture in database by id
     * @param id
     * @return {@link Picture}
     */
    Picture findById(int id);

    /**
     * Method search picture in database by name
     * @param name
     * @return {@link Picture}
     */
    Picture findByName(String name);

    /**
     * Method edit picture in database
     * @param user
     * @return {@link Picture}
     */
    Picture edit(Picture user);

    /**
     * Method get all pictures from database
     * @return List<{@link User}>
     */
    List<Picture> findAll();
}