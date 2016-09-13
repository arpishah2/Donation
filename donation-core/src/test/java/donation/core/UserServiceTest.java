package donation.core;

import donation.core.service.api.UserService;
import donation.core.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/application-context.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserByEmail() {
      User user = userService.getUserByEmail("foo@foo.org");
      assertNotNull(user);
      assertEquals("foo@foo.org", user.getEmail());
    }

}
