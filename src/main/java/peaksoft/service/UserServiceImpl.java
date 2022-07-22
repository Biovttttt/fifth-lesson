package peaksoft.service;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends UserDaoHibernateImpl implements UserService {


    public UserServiceImpl() {
        super();
    }

    @Override
    public User UpdateUser(long id, String name, String surname, byte age) {
        return super.UpdateUser(id, name, surname, age);
    }

    @Override
    public void createUsersTable() {
        super.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        super.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void saveUser(User user) {
        super.saveUser(user);
    }

    @Override
    public void removeUserById(long id) {
        super.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return super.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        super.cleanUsersTable();
    }
}
