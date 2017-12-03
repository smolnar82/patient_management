package hu.kuncystem.patient.dao.user;

import hu.kuncystem.patient.pojo.user.User;

/**
 * This interface defines the standard operations to be performed on a model
 * object(s).
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
public interface UserDao {
    /**
     * Delete one row from the database.
     *
     * @param user
     *            Object.User is a simple POJO object.
     * @return It will return true for success otherwise it will return false.
     */
    public boolean deleteUser(User user);

    /**
     * Get one row from the database.
     *
     * @param id
     *            Unique identification of the row.
     * @return Object.User is a simple POJO object.
     */
    public User getUser(long id);

    /**
     * Get one row from the database. Both parameters together identify one user
     * in the database.
     *
     * @param name
     *            This is the user's name.
     * @param password
     *            This is the user's password.
     * @return Object.User is a simple POJO object.
     */
    public User getUser(String name, String password);

    /**
     * Insert new user into the database.
     *
     * @param user
     *            Object.User is a simple POJO object(Patient or Doctor model
     *            object).
     * @return This is new row id.
     */
    public User saveUser(User user);

    /**
     * Update one row in the database.
     *
     * @param user
     *            Object.User is a simple POJO object.
     * @return It will return true for success otherwise it will return false.
     */
    public boolean updateUser(User user);
}
