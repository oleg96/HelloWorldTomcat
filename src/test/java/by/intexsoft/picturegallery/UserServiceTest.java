package by.intexsoft.picturegallery;

import by.intexsoft.picturegallery.model.User;
import by.intexsoft.picturegallery.service.UserService;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void createUser() {
        user = new User();
        user.id = 1;
        user.name = "Admin";
    }

    @Test
    public void testFindById() {
        User loadedUser = userService.findById(1);
        assertThat(loadedUser.id, is(user.id));
        assertThat(loadedUser.name, is(user.name));
    }

    @Test
    public void testFindByName() {
        User loadedUser = userService.findByName("Admin");
        assertThat(loadedUser.id, is(user.id));
        assertThat(loadedUser.name, is(user.name));
    }
}
