package by.intexsoft.helloworldtomcat.controller;

import by.intexsoft.helloworldtomcat.model.Picture;
import by.intexsoft.helloworldtomcat.service.PictureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Picture controller for application
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureController.class);

    /**
     * Method add <{@link Picture}> into database
     * @return List<{@link Picture}>
     */
    @RequestMapping("/add")
    public ResponseEntity<?> add(@RequestBody String data) throws IOException {
        LOGGER.info("Start add picture");
        ObjectMapper mapper = new ObjectMapper();
        Picture picture = mapper.readValue(data, Picture.class);
        Picture newPicture = new Picture();
        newPicture.author = picture.author;
        newPicture.name = picture.name;
        newPicture.description = picture.description;
        newPicture.owner = picture.owner;
        newPicture.tags = picture.tags;
        newPicture.image = picture.image;
        if (pictureService.findByName(newPicture.name) == null) {
            Picture addedPicture = pictureService.add(newPicture);
            if (addedPicture != null) {
                LOGGER.info("Adding picture successful");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        LOGGER.error("Adding picture failed");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Method get all pictures in JSON format
     * @return List<{@link Picture}>
     */
    @RequestMapping("/pictures")
    public List<Picture> getAllPictures() {
        LOGGER.info("Start getAllPictures method");
        try {
            List<Picture> pictures = pictureService.findAll();
            return pictures;
        } catch (NullPointerException e) {
            LOGGER.error("Exception in getAllPictures method: " + e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Method get picture by id in JSON format
     * @param id
     * @return {@link Picture}
     */
    @RequestMapping("/pictures/:{id}")
    public Picture getPictureById(@PathVariable("id") int id) {
        LOGGER.info("Start getPicture method");
        try {
            Picture picture = pictureService.findById(id);
            return picture;
        } catch (NullPointerException e) {
            LOGGER.error("Exception in getPicture method: " + e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Method get picture by name in JSON format
     * @param name
     * @return {@link Picture}
     */
    @RequestMapping("/pictures/{name}")
    public Picture getPictureByName(@PathVariable("name") String name) {
        LOGGER.info("Start getPicture method");
        try {
            Picture picture = pictureService.findByName(name);
            return picture;
        } catch (NullPointerException e) {
            LOGGER.error("Exception in getPicture method: " + e.getLocalizedMessage());
            return null;
        }
    }
}
