package hu.kuncystem.patient.dao.user;

import hu.kuncystem.patient.dao.exception.DatabaseException;
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
     * @throws DatabaseException
     *             if there is any problem issuing the update
     */
    public boolean deleteUser(User user) throws DatabaseException;

    /**
     * Get one row from the database.
     *
     * @param id
     *            Unique identification of the row.
     * @return Object.User is a simple POJO object.
     * @throws DatabaseException
     *             if the query fails
     */
    public User getUser(long id) throws DatabaseException;

    /**
     * Get one row from the database. Both parameters together identify one user
     * in the database.
     *
     * @param name
     *            This is the user's name.
     * @return Object.User is a simple POJO object.
     * @throws DatabaseException
     *             if the query fails
     */
    public User getUser(String name) throws DatabaseException;

    /**
     * Get one row from the database. Both parameters together identify one user
     * in the database.
     *
     * @param name
     *            This is the user's name.
     * @param password
     *            This is the user's password.
     * @return Object.User is a simple POJO object.
     * @throws DatabaseException
     *             if the query fails
     */
    public User getUser(String name, String password) throws DatabaseException;

    /**
     * Insert new user into the database.
     *
     * @param user
     *            Object.User is a simple POJO object(Patient or Doctor model
     *            object).
     * @return This is a simple POJO that we added in parameter and this object
     *         contains the new id that we got from the database.
     * @throws DatabaseException
     *             if there is any problem issuing the update
     */
    public User saveUser(User user) throws DatabaseException;

    /**
     * Update one row in the database.
     *
     * @param user
     *            Object.User is a simple POJO object.
     * @return It will return true for success otherwise it will return false.
     * @throws DatabaseException
     *             if there is any problem issuing the update
     */
    public boolean updateUser(User user) throws DatabaseException;
}
