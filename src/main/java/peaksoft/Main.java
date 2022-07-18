package peaksoft;

import peaksoft.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Nursultan","Mumahmad",(byte) 20);
        userService.saveUser("Tilek","Mumahmad",(byte) 21);
        userService.saveUser("Dastan","Mumahmad",(byte) 22);
        userService.saveUser("Azat","Mumahmad",(byte) 23);
        System.out.println(userService.getAllUsers().toString());
        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
