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
        userService.saveUser(new User("tilek","Birimkulov",(byte)25));
        System.out.println(userService.getAllUsers());;
        userService.UpdateUser(1,"Ruslan","Kalmatova",(byte) 20);
         userService.removeUserById(1);
        userService.dropUsersTable();
         userService.createUsersTable();
        userService.saveUser(new User("tilek","Birimkulov",(byte)25));
//

//
//
//
//
    }
}
