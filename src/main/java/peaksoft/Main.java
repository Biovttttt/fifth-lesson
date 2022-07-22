package peaksoft;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;

import javax.security.auth.login.Configuration;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.removeUserById(2);
        System.out.println(userService.getAllUsers());;
        userService.UpdateUser(3,"Ruslan","Kalmatova",(byte) 20);
        userService.dropUsersTable();
        userService.createUsersTable();
    }
}
