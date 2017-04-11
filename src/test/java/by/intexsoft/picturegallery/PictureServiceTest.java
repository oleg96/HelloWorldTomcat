package by.intexsoft.picturegallery;

import by.intexsoft.picturegallery.model.Picture;
import by.intexsoft.picturegallery.service.PictureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class PictureServiceTest {

    @Autowired
    private PictureService pictureService;

    private Picture picture;

    @Before
    public void createPicture() {
        picture = new Picture();
        picture.id = 1;
        picture.author = "Victor Vasnetsov";
    }

    @Test
    public void testFindById() {
        Picture loadedPicture = pictureService.findById(1);
        assertThat(loadedPicture.id, is(picture.id));
        assertThat(loadedPicture.author, is(picture.author));
    }

    @Test
    public void testFindByName() {
        Picture loadedPicture = pictureService.findByName("Bogatyri");
        assertThat(loadedPicture.id, is(picture.id));
        assertThat(loadedPicture.author, is(picture.author));
    }
}
