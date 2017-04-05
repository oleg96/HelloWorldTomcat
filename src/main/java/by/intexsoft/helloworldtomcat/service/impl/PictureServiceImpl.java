package by.intexsoft.helloworldtomcat.service.impl;

import by.intexsoft.helloworldtomcat.model.Picture;
import by.intexsoft.helloworldtomcat.repository.PictureRepository;
import by.intexsoft.helloworldtomcat.service.PictureService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Implementation of {@link PictureService} interface
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public Picture add(Picture picture) {
        Picture savedPicture = pictureRepository.save(picture);
        return savedPicture;
    }

    @Override
    public void delete(int id) {
        pictureRepository.delete(id);
    }


    public Picture findById(int id) {
        Picture picture = pictureRepository.findOne(id);
        picture.image = "data:image/jpeg;charset=utf-8;base64,"+Base64.encodeBase64String(getImageData(picture.pathToImage));
        return picture;
    }

    @Override
    public Picture findByName(String name) {
        Picture picture = pictureRepository.findByName(name);
        picture.image = "data:image/jpeg;charset=utf-8;base64,"+Base64.encodeBase64String(getImageData(picture.pathToImage));
        return picture;
    }

    @Override
    public Picture edit(Picture picture) {
        return pictureRepository.saveAndFlush(picture);
    }

    @Override
    public List<Picture> findAll() {
        List<Picture> pictures = pictureRepository.findAll();
        for (Picture picture : pictures) {
            picture.image = "data:image/jpeg;charset=utf-8;base64,"+Base64.encodeBase64String(getImageData(picture.pathToImage));
        }
        return pictures;
    }

    public byte[] getImageData(String pathToImage) {
        try {
            byte[] imageData = IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream(pathToImage));
            return imageData;
        }
        catch (IOException ex) {
            return null;
        }
    }
}