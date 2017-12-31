package hu.kuncystem.patient.servicelayer.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.servicelayer.utilities.Hash;

/**
 * Testing the DefaultUserManager methods
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. dec. 28.
 * 
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/beans_settings.xml" })
@ActiveProfiles("live")
public class DefaultUserManagerTest {
    @Autowired
    private UserManager userManager;

    @Test
    public void start() {
        // create new user
        User user = userManager.createUser("user1", Hash.MD5("123456"), true);
        assertNotNull(user);
        assertTrue("createNewUser:32 > new user create failed", user.getId() > 0);

        // update user data
        boolean ok = userManager.updateUser(user.getId(), user.getUserName(), Hash.MD5("abcd1234"), true, null, null);
        assertTrue("updateUser:50 > update user's data failed", ok);

        // get user data by id
        String oldPass = user.getPassword();
        user = userManager.getUser(user.getId());
        assertNotNull(user);
        assertTrue("user password update failed", oldPass != user.getPassword());

        // get user data by name and password
        user = userManager.getUser("user1", Hash.MD5("abcd1234"));
        assertNotNull(user);
        // check if user not found
        User user1 = userManager.getUser("user1", Hash.MD5("xxxx"));
        assertTrue(user1 == null);

        // delete an user
        assertTrue("removeUser:65 > delete user failed", userManager.removeUser(user.getId()));
    }
}
