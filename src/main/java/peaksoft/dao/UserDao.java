package peaksoft.dao;

import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;

    void saveUser(User user);

     User UpdateUser(long id,String name,String surname,byte age);

    void removeUserById(long id);

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}
