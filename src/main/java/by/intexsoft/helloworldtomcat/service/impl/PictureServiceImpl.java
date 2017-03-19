package by.intexsoft.helloworldtomcat.service.impl;

import by.intexsoft.helloworldtomcat.model.Picture;
import by.intexsoft.helloworldtomcat.repository.PictureRepository;
import by.intexsoft.helloworldtomcat.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Picture savedPicture = pictureRepository.saveAndFlush(picture);
        return savedPicture;
    }

    @Override
    public void delete(int id) {
        pictureRepository.delete(id);
    }

    @Override
    public Picture findByName(String name) {
        return pictureRepository.findByName(name);
    }

    @Override
    public Picture edit(Picture picture) {
        return pictureRepository.saveAndFlush(picture);
    }

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }
}