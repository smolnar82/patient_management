package hu.kuncystem.patient.servicelayer.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserGroup;
import hu.kuncystem.patient.servicelayer.utilities.Hash;

/**
 * Testing the DefaultUserGroupManager methods
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. dec. 31.
 * 
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/beans_settings.xml" })
@ActiveProfiles("live")
public class DefaultUserGroupManagerTest {
    @Autowired
    private UserGroupManager userGroupManager;

    @Autowired
    private UserManager userManager;

    @Test
    public void start() {
        // create new group
        UserGroup group = userGroupManager.createGroup("Group1", "note of test group");
        assertNotNull(group);
        assertTrue("createNewGroup:34 > new group create failed", group.getId() > 0);

        // create new user
        User user = userManager.createUser("Teszt User", Hash.MD5("abcd1234"), true);
        assertNotNull(user);

        // save user and group relation
        assertTrue("saveRelation:46 > user and group relation create failed",
                userGroupManager.saveRelation(user.getId(), group.getId()));

        // get group data
        group = userGroupManager.getGroup(group.getId());
        assertNotNull(group);

        // get group list by user id
        List<UserGroup> groupList = userGroupManager.getGroupOfUser(user.getId());
        assertTrue("getGroupOfUser:60 > group list not found by user id", groupList.size() > 0);

        // get user list by group id
        List<User> userList = userGroupManager.getUsersFromGroup(group.getId());
        assertTrue("getUsersFromGroup:60 > user list not found by group id", userList.size() > 0);
    }
}
