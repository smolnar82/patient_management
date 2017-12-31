package hu.kuncystem.patient.servicelayer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import hu.kuncystem.patient.dao.user.UserDao;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserFactory;

/**
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
@Service
public class DefaultUserManager implements UserManager {

    @Autowired
    @Qualifier("JDBCUserDao")
    private UserDao userDao;

    private final UserFactory userFactory;

    /**
     * This class manages all of the user's data. We can reach some operation
     * functions through the class. We can create, update or delete one user�s
     * data, too.
     *
     */
    public DefaultUserManager() {
        userFactory = new UserFactory();
    }

    public User createUser(String name, String password, boolean active) {
        return this.createUser(name, password, active, null, null);
    }

    public User createUser(String name, String password, boolean active, String fullname, String email) {
        User user = userFactory.getUser(UserFactory.DEFAULT);
        user.setUserName(name);
        user.setPassword(password);
        user.setActive(active);
        user.setFullname(fullname);
        user.setEmail(email);

        return userDao.saveUser(user);
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    public User getUser(String name, String password) {
        return userDao.getUser(name, password);
    }

    public boolean removeUser(long userId) {
        User user = userFactory.getUser(UserFactory.DEFAULT);
        user.setId(userId);

        return userDao.deleteUser(user);
    }

    public boolean updateUser(long userId, String name, String password, boolean active, String fullname,
            String email) {
        User user = userFactory.getUser(UserFactory.DEFAULT);
        user.setId(userId);
        user.setUserName(name);
        user.setPassword(password);
        user.setActive(active);
        user.setEmail(email);
        user.setFullname(fullname);

        return userDao.updateUser(user);
    }

}
