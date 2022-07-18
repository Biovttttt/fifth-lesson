package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends UserDaoJdbcImpl implements UserService {
    public UserServiceImpl() throws SQLException {
        super();
    }

    @Override
    public void createUsersTable() throws SQLException {
        super.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        super.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        super.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        super.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return super.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        super.cleanUsersTable();
    }
}
