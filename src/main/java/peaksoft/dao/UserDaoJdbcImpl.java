package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl  implements UserDao {
    Connection connection = Util.Connection();


    public UserDaoJdbcImpl() throws SQLException {

    }

    public void createUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        try {
            String sql = "create table if not exists Users(\n" +
                    "  id SERIAL PRIMARY KEY  ,\n" +
                    "  name varchar(50),\n" +
                    " lastName varchar(60) ,\n" +
                    " age INTEGER\n" +
                    ");";
            statement.executeUpdate(sql);
            System.out.println("Таблица User успешно создано");
        } catch (SQLException s) {
            System.out.println("Вышла ошибка при создание таблицы");
        }


    }

    public void dropUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        try {
            String sql = "drop table if exists Users;";
            statement.executeUpdate(sql);
            System.out.println("Таблица User успешно удалено");
        } catch (SQLException s) {
            System.out.println("Вышла ошибка при удаленение таблицы");
        }
    }

    public void saveUser(String name, String lastName, byte age)  {

        String sql = "insert into Users (name, lastName, age) \n" +
                "values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();

            System.out.println("User успешно сохранено");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        String sql = "delete from Users where id=?" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            System.out.println("User успешно Удалено");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from users;");
        List<User> users = new ArrayList<>();


        while (resultSet.next()){
            User user2 = new User();
            user2.setId(resultSet.getLong("id"));
            user2.setName(resultSet.getString("name"));
            user2.setLastName(resultSet.getString("lastname"));
            user2.setAge(resultSet.getByte("age"));
            users.add(user2);
        }

        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        try {
            String sql = "truncate table Users;";
            statement.executeUpdate(sql);
            System.out.println("Таблица User успешно Очистились");
        } catch (SQLException s) {
            System.out.println("Вышла ошибка при очистке таблицы");
        }
    }}