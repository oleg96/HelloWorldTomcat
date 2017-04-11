package by.intexsoft.helloworldtomcat.controller;

import by.intexsoft.helloworldtomcat.model.Picture;
import by.intexsoft.helloworldtomcat.service.PictureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

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
     * Method add {@link Picture} to database
     * @return {@link ResponseEntity}
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addPicture(@RequestBody Picture requestPicture) {
        LOGGER.info("Start adding picture");
        if (pictureService.findById(requestPicture.id) == null) {
            Picture picture = pictureService.add(requestPicture);
            if (picture != null) {
                LOGGER.info("Adding picture successful");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        LOGGER.error("Adding picture failed");
        return new ResponseEntity<>("Adding picture failed", HttpStatus.BAD_REQUEST);
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

    /**
     * Method edit {@link Picture} in database
     * @return {@link ResponseEntity}
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<?> editPicture(@RequestBody Picture requestPicture) {
        LOGGER.info("Start editing picture");
        if (isNotEmpty(requestPicture.author) && isNotEmpty(requestPicture.name) && isNotEmpty(requestPicture.description) && isNotEmpty(requestPicture.owner) && isNotEmpty(requestPicture.tags) && isNotEmpty(requestPicture.image)) {
            Picture picture = pictureService.edit(requestPicture);
            if (picture != null) {
                LOGGER.info("Edit picture successful");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        LOGGER.error("Edit picture failed");
        return new ResponseEntity<>("Edit picture failed", HttpStatus.BAD_REQUEST);
    }

    /**
     * Method delete {@link Picture} from database
     * @return {@link ResponseEntity}
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deletePicture(@RequestBody Picture requestPicture) {
        LOGGER.info("Start deleting picture");
        if (requestPicture.id > 0) {
            pictureService.delete(requestPicture.id);
            LOGGER.info("Delete picture successful");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        LOGGER.error("Delete picture failed");
        return new ResponseEntity<>("Delete picture failed", HttpStatus.BAD_REQUEST);
    }
}
