package peaksoft.service;

import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;



    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}

